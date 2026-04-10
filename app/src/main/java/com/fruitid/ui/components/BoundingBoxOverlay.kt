package com.fruitid.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fruitid.ml.DetectionResult
import com.fruitid.ui.theme.ScientificNameStyle
import com.fruitid.ui.theme.TextPrimary
import com.fruitid.ui.theme.TextSecondary

@Composable
fun BoundingBoxOverlay(
    detections: List<DetectionResult>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            detections.forEach { detection ->
                drawChamferedBoundingBox(detection)
            }
        }

        // Draw labels above boxes
        detections.forEach { detection ->
            BoxLabel(
                detection = detection,
                modifier = Modifier.align(Alignment.TopStart)
            )
        }
    }
}

@Composable
private fun BoxLabel(
    detection: DetectionResult,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    
    // Convert normalized coordinates to pixels
    val screenWidth = with(density) { 360.dp.toPx() } // Approximate
    val screenHeight = with(density) { 640.dp.toPx() }
    
    val x1 = detection.boundingBox.x1 * screenWidth
    val y1 = detection.boundingBox.y1 * screenHeight
    
    Box(
        modifier = modifier
            .offset(
                x = with(density) { x1.toDp() },
                y = with(density) { (y1 - 60).toDp() }
            )
    ) {
        GlassmorphismCard(
            cornerRadius = 8.dp
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Geometric glyph
                CategoryGlyph(
                    categoryColor = detection.category.color,
                    size = 24.dp,
                    fill = true
                )
                
                Column {
                    // Common name
                    Text(
                        text = detection.label,
                        fontSize = 18.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                        color = TextPrimary
                    )
                    // Scientific name + confidence
                    Text(
                        text = "${detection.scientificName}  ${(detection.confidence * 100).toInt()}%",
                        style = ScientificNameStyle,
                        fontSize = 13.sp,
                        color = TextSecondary
                    )
                }
            }
        }
    }
}

private fun DrawScope.drawChamferedBoundingBox(detection: DetectionResult) {
    val color = detection.category.color
    val strokeWidth = 1.5.dp.toPx()
    val chamferSize = 12.dp.toPx()
    
    // Get bounding box in canvas coordinates
    val left = detection.boundingBox.x1 * size.width
    val top = detection.boundingBox.y1 * size.height
    val right = detection.boundingBox.x2 * size.width
    val bottom = detection.boundingBox.y2 * size.height
    
    val width = right - left
    val height = bottom - top
    
    // Draw chamfered corners only (not full rectangle)
    
    // Top-left corner
    drawLine(
        color = color,
        start = Offset(left + chamferSize, top),
        end = Offset(left, top),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Square
    )
    drawLine(
        color = color,
        start = Offset(left, top),
        end = Offset(left, top + chamferSize),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Square
    )
    
    // Top-right corner
    drawLine(
        color = color,
        start = Offset(right - chamferSize, top),
        end = Offset(right, top),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Square
    )
    drawLine(
        color = color,
        start = Offset(right, top),
        end = Offset(right, top + chamferSize),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Square
    )
    
    // Bottom-left corner
    drawLine(
        color = color,
        start = Offset(left, bottom - chamferSize),
        end = Offset(left, bottom),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Square
    )
    drawLine(
        color = color,
        start = Offset(left, bottom),
        end = Offset(left + chamferSize, bottom),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Square
    )
    
    // Bottom-right corner
    drawLine(
        color = color,
        start = Offset(right, bottom - chamferSize),
        end = Offset(right, bottom),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Square
    )
    drawLine(
        color = color,
        start = Offset(right - chamferSize, bottom),
        end = Offset(right, bottom),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Square
    )
}

@Composable
fun DetectionClusterBadge(
    count: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    GlassmorphismSurface(
        modifier = modifier,
        cornerRadius = 16.dp
    ) {
        Text(
            text = "+$count",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            fontSize = 14.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
            color = color
        )
    }
}
