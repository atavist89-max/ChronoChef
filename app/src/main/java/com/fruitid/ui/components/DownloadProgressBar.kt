package com.fruitid.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fruitid.data.download.DownloadProgress
import com.fruitid.data.download.DownloadState
import com.fruitid.ui.theme.Primary
import com.fruitid.ui.theme.TextPrimary
import com.fruitid.ui.theme.TextSecondary

@Composable
fun DownloadProgressBar(
    progress: DownloadProgress,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Progress text
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = formatBytes(progress.bytesDownloaded) + " / " + formatBytes(progress.totalBytes),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = TextPrimary
            )
            
            when (progress.state) {
                DownloadState.DOWNLOADING -> {
                    Text(
                        text = formatSpeed(progress.speedBytesPerSecond),
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                }
                DownloadState.VERIFYING -> {
                    Text(
                        text = "Verifying...",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                }
                DownloadState.MOVING -> {
                    Text(
                        text = "Moving...",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                }
                else -> {}
            }
        }
        
        // Progress bar
        when (progress.state) {
            DownloadState.DOWNLOADING -> {
                val animatedProgress by animateFloatAsState(
                    targetValue = progress.progressPercent,
                    label = "download_progress"
                )
                
                LinearProgressIndicator(
                    progress = animatedProgress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = Primary,
                    trackColor = Color.LightGray
                )
            }
            DownloadState.VERIFYING, DownloadState.MOVING -> {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = Primary
                )
            }
            else -> {
                LinearProgressIndicator(
                    progress = if (progress.progressPercent > 0) progress.progressPercent else 0f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = Primary,
                    trackColor = Color.LightGray
                )
            }
        }
        
        // Percentage text
        if (progress.state == DownloadState.DOWNLOADING) {
            Text(
                text = "${(progress.progressPercent * 100).toInt()}%",
                fontSize = 12.sp,
                color = TextSecondary,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

private fun formatBytes(bytes: Long): String {
    return when {
        bytes >= 1_073_741_824 -> String.format("%.1f GB", bytes / 1_073_741_824.0)
        bytes >= 1_048_576 -> String.format("%.1f MB", bytes / 1_048_576.0)
        bytes >= 1024 -> String.format("%.1f KB", bytes / 1024.0)
        else -> "$bytes B"
    }
}

private fun formatSpeed(bytesPerSecond: Long): String {
    return when {
        bytesPerSecond >= 1_048_576 -> String.format("%.1f MB/s", bytesPerSecond / 1_048_576.0)
        bytesPerSecond >= 1024 -> String.format("%.1f KB/s", bytesPerSecond / 1024.0)
        else -> "$bytesPerSecond B/s"
    }
}
