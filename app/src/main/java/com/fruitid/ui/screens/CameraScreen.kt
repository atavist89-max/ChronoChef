package com.fruitid.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.view.PreviewView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.fruitid.camera.CameraManager
import com.fruitid.ml.DetectionResult
import com.fruitid.ui.components.BoundingBoxOverlay
import com.fruitid.ui.theme.*
import com.fruitid.ui.viewmodel.CameraViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CameraScreen(
    onDetectionTap: (DetectionResult) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CameraViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val vibrator = context.getSystemService(Vibrator::class.java)

    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) ==
                    PackageManager.PERMISSION_GRANTED
        )
    }

    val detections by viewModel.detections.collectAsState()
    val isStandby by viewModel.isStandby.collectAsState()
    var showGuide by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasCameraPermission = isGranted
    }

    // Guide text delay
    LaunchedEffect(isStandby) {
        if (isStandby) {
            delay(500)
            showGuide = true
        } else {
            showGuide = false
        }
    }

    // Haptic feedback on high confidence detection
    LaunchedEffect(detections) {
        if (detections.any { it.isHighConfidence() }) {
            vibrator?.vibrate(
                VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE)
            )
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        if (hasCameraPermission) {
            // Camera preview
            AndroidView(
                factory = { ctx ->
                    PreviewView(ctx).apply {
                        scaleType = PreviewView.ScaleType.FILL_CENTER
                        viewModel.startCamera(lifecycleOwner, this)
                    }
                },
                modifier = Modifier.fillMaxSize()
            )

            // Detection overlay
            BoundingBoxOverlay(
                detections = detections,
                modifier = Modifier.fillMaxSize()
            )

            // Guide text
            AnimatedVisibility(
                visible = showGuide,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(
                    text = "Steady the camera on fruit",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextSecondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.alpha(0.7f)
                )
            }

            // History drag handle indicator at bottom
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
                    .width(40.dp)
                    .height(4.dp)
                    .background(
                        color = TextTertiary.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(2.dp)
                    )
            )

        } else {
            // Permission request UI
            CameraPermissionRequest(
                onRequestPermission = { permissionLauncher.launch(Manifest.permission.CAMERA) }
            )
        }
    }
}

@Composable
private fun CameraPermissionRequest(
    onRequestPermission: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Camera Permission Required",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Fruit Identifier needs camera access to identify fruits in real-time.",
            fontSize = 16.sp,
            color = TextSecondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onRequestPermission,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary
            )
        ) {
            Text(
                text = "Grant Permission",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
