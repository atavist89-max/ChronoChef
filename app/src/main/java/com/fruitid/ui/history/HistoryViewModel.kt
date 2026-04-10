package com.fruitid.ui.history

import android.content.Context
import android.os.Environment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fruitid.data.local.prefs.SettingsPrefs
import com.fruitid.data.repository.DetectionRepository
import com.fruitid.domain.model.Detection
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val detectionRepository: DetectionRepository,
    private val settingsPrefs: SettingsPrefs
) : ViewModel() {

    val detections = detectionRepository.getDetectionHistory()

    private val _isMultiSelectMode = MutableStateFlow(false)
    val isMultiSelectMode: StateFlow<Boolean> = _isMultiSelectMode.asStateFlow()

    private val _selectedIds = MutableStateFlow<Set<Long>>(emptySet())
    val selectedIds: StateFlow<Set<Long>> = _selectedIds.asStateFlow()

    val allowMobileData: StateFlow<Boolean> = settingsPrefs.allowMobileData
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    fun toggleSelection(id: Long) {
        _isMultiSelectMode.value = true
        _selectedIds.update { current ->
            if (current.contains(id)) {
                current - id
            } else {
                current + id
            }
        }
    }

    fun clearSelection() {
        _selectedIds.value = emptySet()
        _isMultiSelectMode.value = false
    }

    fun deleteSelected() {
        viewModelScope.launch {
            _selectedIds.value.forEach { id ->
                detectionRepository.deleteDetection(id)
            }
            clearSelection()
        }
    }

    fun deleteDetection(id: Long) {
        viewModelScope.launch {
            detectionRepository.deleteDetection(id)
        }
    }

    fun clearAllHistory() {
        viewModelScope.launch {
            detectionRepository.clearAllHistory()
        }
    }

    fun setAllowMobileData(allow: Boolean) {
        viewModelScope.launch {
            settingsPrefs.setAllowMobileData(allow)
        }
    }

    fun exportToCsv() {
        viewModelScope.launch {
            try {
                val detections = detectionRepository.getRecentDetections(1000)
                val csvFile = File(
                    context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),
                    "fruit_detections_${System.currentTimeMillis()}.csv"
                )

                FileWriter(csvFile).use { writer ->
                    writer.append("Timestamp,Common Name,Scientific Name,Confidence,Category\n")
                    
                    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    
                    detections.forEach { detection ->
                        writer.append("${dateFormat.format(Date(detection.timestamp))},")
                        writer.append("\"${detection.commonName}\",")
                        writer.append("\"${detection.scientificName}\",")
                        writer.append("${(detection.confidence * 100).toInt()}%,")
                        writer.append("${detection.category.displayName}\n")
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
