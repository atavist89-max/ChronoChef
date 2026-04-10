package com.fruitid.ui.viewmodel

import android.content.Context
import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fruitid.camera.CameraManager
import com.fruitid.ml.DetectionResult
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val cameraManager: CameraManager
) : ViewModel() {

    private val _detections = MutableStateFlow<List<DetectionResult>>(emptyList())
    val detections: StateFlow<List<DetectionResult>> = _detections.asStateFlow()

    private val _isStandby = MutableStateFlow(false)
    val isStandby: StateFlow<Boolean> = _isStandby.asStateFlow()

    private val _selectedDetection = MutableStateFlow<DetectionResult?>(null)
    val selectedDetection: StateFlow<DetectionResult?> = _selectedDetection.asStateFlow()

    init {
        cameraManager.onDetections = { results ->
            viewModelScope.launch {
                _detections.value = results
            }
        }
        cameraManager.onStandbyStateChange = { standby ->
            viewModelScope.launch {
                _isStandby.value = standby
            }
        }
    }

    fun startCamera(lifecycleOwner: LifecycleOwner, previewView: PreviewView) {
        viewModelScope.launch {
            cameraManager.startCamera(lifecycleOwner, previewView)
        }
    }

    fun selectDetection(detection: DetectionResult) {
        _selectedDetection.value = detection
    }

    fun clearSelection() {
        _selectedDetection.value = null
    }

    override fun onCleared() {
        super.onCleared()
        cameraManager.shutdown()
    }
}
