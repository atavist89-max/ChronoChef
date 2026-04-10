package com.fruitid.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fruitid.data.download.DownloadState
import com.fruitid.ui.components.DownloadProgressBar
import com.fruitid.ui.theme.*
import com.fruitid.ui.viewmodel.DownloadViewModel

@Composable
fun DownloadScreen(
    onDownloadComplete: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DownloadViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val progress by viewModel.downloadProgress.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState == DownloadState.COMPLETED) {
            onDownloadComplete()
        }
    }

    Scaffold(
        modifier = modifier,
        containerColor = Background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Text(
                text = "Model Download Required",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Description
            Text(
                text = "Download the Gemma 4 E4B vision model (2.5 GB) to identify fruits in real-time.",
                fontSize = 16.sp,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(48.dp))

            when (uiState) {
                DownloadState.IDLE, DownloadState.CANCELLED -> {
                    DownloadOptions(
                        onWifiClick = { viewModel.startDownload(useMobileData = false) },
                        onMobileClick = { viewModel.startDownload(useMobileData = true) },
                        canResume = viewModel.canResume()
                    )
                }

                DownloadState.DOWNLOADING, DownloadState.VERIFYING, DownloadState.MOVING -> {
                    DownloadProgressSection(
                        progress = progress,
                        onCancel = { viewModel.cancelDownload() }
                    )
                }

                DownloadState.NETWORK_ERROR -> {
                    ErrorState(
                        message = "Network connection lost",
                        actionText = "Resume Download",
                        onAction = { viewModel.resumeDownload() }
                    )
                }

                DownloadState.STORAGE_FULL -> {
                    ErrorState(
                        message = "Storage full. Need ${viewModel.getRequiredStorage()} MB free.",
                        actionText = "Retry",
                        onAction = { viewModel.retryDownload() }
                    )
                }

                DownloadState.CORRUPTED -> {
                    ErrorState(
                        message = "File corrupted. Retry from beginning.",
                        actionText = "Retry",
                        onAction = { viewModel.retryFromBeginning() }
                    )
                }

                DownloadState.FAILED -> {
                    ErrorState(
                        message = "Download failed. Please try again.",
                        actionText = "Retry",
                        onAction = { viewModel.retryDownload() }
                    )
                }

                DownloadState.COMPLETED -> {
                    DownloadComplete()
                }

                else -> {}
            }
        }
    }
}

@Composable
private fun DownloadOptions(
    onWifiClick: () -> Unit,
    onMobileClick: () -> Unit,
    canResume: Boolean
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (canResume) {
            Text(
                text = "Download interrupted. Choose how to continue.",
                fontSize = 14.sp,
                color = TextSecondary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Primary button - Use Mobile Data
        Button(
            onClick = onMobileClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary
            )
        ) {
            Text(
                text = "Use Mobile Data",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        // Secondary button - Download on WiFi
        OutlinedButton(
            onClick = onWifiClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Secondary
            )
        ) {
            Text(
                text = "Download on WiFi",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun DownloadProgressSection(
    progress: com.fruitid.data.download.DownloadProgress,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DownloadProgressBar(
            progress = progress,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextButton(
            onClick = onCancel,
            colors = ButtonDefaults.textButtonColors(
                contentColor = Error
            )
        ) {
            Text(
                text = "Cancel",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun ErrorState(
    message: String,
    actionText: String,
    onAction: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 16.sp,
            color = Error,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onAction,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary
            )
        ) {
            Text(
                text = actionText,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun DownloadComplete() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Download Complete",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = GreenCategory
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Opening camera...",
            fontSize = 14.sp,
            color = TextSecondary
        )
    }
}
