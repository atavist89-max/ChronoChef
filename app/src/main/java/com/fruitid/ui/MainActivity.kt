package com.fruitid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fruitid.data.repository.ModelRepository
import com.fruitid.domain.model.Detection
import com.fruitid.ui.screens.CameraScreen
import com.fruitid.ui.screens.DetectionDetailSheet
import com.fruitid.ui.screens.DownloadScreen
import com.fruitid.ui.theme.FruitIdentifierTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var modelRepository: ModelRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val isModelReady = modelRepository.isModelDownloaded()

        setContent {
            FruitIdentifierTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FruitIdentifierApp(
                        isModelDownloaded = isModelReady
                    )
                }
            }
        }
    }
}

@Composable
fun FruitIdentifierApp(
    isModelDownloaded: Boolean
) {
    val navController = rememberNavController()
    var selectedDetection by remember { mutableStateOf<Detection?>(null) }

    NavHost(
        navController = navController,
        startDestination = if (isModelDownloaded) "camera" else "download"
    ) {
        composable("download") {
            DownloadScreen(
                onDownloadComplete = {
                    navController.navigate("camera") {
                        popUpTo("download") { inclusive = true }
                    }
                }
            )
        }

        composable("camera") {
            CameraScreen(
                onDetectionTap = { detection ->
                    selectedDetection = detection
                }
            )

            // Show detail sheet if detection selected
            selectedDetection?.let { detection ->
                DetectionDetailSheet(
                    detection = detection,
                    onDismiss = { selectedDetection = null },
                    onSaveToHistory = {
                        // Save to history logic
                        selectedDetection = null
                    }
                )
            }
        }
    }
}
