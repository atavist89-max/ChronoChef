package com.fruitid.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Geometric glyphs for fruit categories.
 * Zero emojis - pure geometric shapes only.
 */

@Composable
fun CircleGlyph(
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier,
    fill: Boolean = false
) {
    Canvas(
        modifier = modifier.size(size),
        onDraw = {
            val radius = size.toPx() / 2 - 2.dp.toPx()
            drawCircle(
                color = color,
                radius = radius,
                center = center,
                style = if (fill) androidx.compose.ui.graphics.drawscope.Fill else Stroke(width = 2.dp.toPx())
            )
        }
    )
}

@Composable
fun TriangleGlyph(
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier,
    rotation: Float = 45f,
    fill: Boolean = false
) {
    Canvas(
        modifier = modifier.size(size),
        onDraw = {
            val width = size.toPx() - 4.dp.toPx()
            val height = size.toPx() - 4.dp.toPx()
            
            val path = Path().apply {
                // Draw equilateral triangle
                val halfWidth = width / 2
                val triangleHeight = (kotlin.math.sqrt(3.0) / 2 * width).toFloat()
                
                moveTo(center.x, center.y - triangleHeight / 2)
                lineTo(center.x + halfWidth, center.y + triangleHeight / 2)
                lineTo(center.x - halfWidth, center.y + triangleHeight / 2)
                close()
            }
            
            if (rotation != 0f) {
                rotate(degrees = rotation, pivot = center) {
                    drawPath(
                        path = path,
                        color = color,
                        style = if (fill) androidx.compose.ui.graphics.drawscope.Fill else Stroke(width = 2.dp.toPx())
                    )
                }
            } else {
                drawPath(
                    path = path,
                    color = color,
                    style = if (fill) androidx.compose.ui.graphics.drawscope.Fill else Stroke(width = 2.dp.toPx())
                )
            }
        }
    )
}

@Composable
fun ChamferedRectGlyph(
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier,
    chamferSize: Dp = 8.dp,
    fill: Boolean = false
) {
    Canvas(
        modifier = modifier.size(size),
        onDraw = {
            val rectSize = size.toPx() - 4.dp.toPx()
            val chamfer = chamferSize.toPx()
            val halfSize = rectSize / 2
            
            val path = Path().apply {
                // Start at top-left after chamfer
                moveTo(center.x - halfSize + chamfer, center.y - halfSize)
                
                // Top edge to top-right chamfer
                lineTo(center.x + halfSize - chamfer, center.y - halfSize)
                
                // Top-right chamfer
                lineTo(center.x + halfSize, center.y - halfSize + chamfer)
                
                // Right edge to bottom-right chamfer
                lineTo(center.x + halfSize, center.y + halfSize - chamfer)
                
                // Bottom-right chamfer
                lineTo(center.x + halfSize - chamfer, center.y + halfSize)
                
                // Bottom edge to bottom-left chamfer
                lineTo(center.x - halfSize + chamfer, center.y + halfSize)
                
                // Bottom-left chamfer
                lineTo(center.x - halfSize, center.y + halfSize - chamfer)
                
                // Left edge to top-left chamfer
                lineTo(center.x - halfSize, center.y - halfSize + chamfer)
                
                close()
            }
            
            drawPath(
                path = path,
                color = color,
                style = if (fill) androidx.compose.ui.graphics.drawscope.Fill else Stroke(width = 2.dp.toPx())
            )
        }
    )
}

@Composable
fun DotClusterGlyph(
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier,
    fill: Boolean = false
) {
    Canvas(
        modifier = modifier.size(size),
        onDraw = {
            val dotRadius = (size.toPx() / 6) - 1.dp.toPx()
            val spacing = size.toPx() / 5
            
            // Three dots in a triangular cluster
            val positions = listOf(
                Offset(center.x, center.y - spacing), // Top
                Offset(center.x - spacing * 0.866f, center.y + spacing * 0.5f), // Bottom left
                Offset(center.x + spacing * 0.866f, center.y + spacing * 0.5f)  // Bottom right
            )
            
            positions.forEach { pos ->
                drawCircle(
                    color = color,
                    radius = dotRadius,
                    center = pos,
                    style = if (fill) androidx.compose.ui.graphics.drawscope.Fill else Stroke(width = 1.5f.dp.toPx())
                )
            }
        }
    )
}

@Composable
fun CheckmarkIcon(
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier.size(size),
        onDraw = {
            val strokeWidth = 2.dp.toPx()
            val checkPath = Path().apply {
                // Start at bottom-left of checkmark
                moveTo(center.x - size.toPx() * 0.25f, center.y)
                // Draw to bottom point
                lineTo(center.x - size.toPx() * 0.05f, center.y + size.toPx() * 0.2f)
                // Draw to top-right
                lineTo(center.x + size.toPx() * 0.3f, center.y - size.toPx() * 0.25f)
            }
            
            drawPath(
                path = checkPath,
                color = color,
                style = Stroke(width = strokeWidth)
            )
        }
    )
}

@Composable
fun CategoryGlyph(
    categoryColor: Color,
    size: Dp,
    modifier: Modifier = Modifier,
    fill: Boolean = false
) {
    // Determine glyph type based on color
    when (categoryColor) {
        com.fruitid.ui.theme.GreenCategory -> CircleGlyph(
            color = categoryColor,
            size = size,
            modifier = modifier,
            fill = fill
        )
        com.fruitid.ui.theme.YellowCategory -> TriangleGlyph(
            color = categoryColor,
            size = size,
            modifier = modifier,
            rotation = 45f,
            fill = fill
        )
        com.fruitid.ui.theme.RedCategory, com.fruitid.ui.theme.OrangeCategory -> ChamferedRectGlyph(
            color = categoryColor,
            size = size,
            modifier = modifier,
            fill = fill
        )
        com.fruitid.ui.theme.PurpleCategory -> DotClusterGlyph(
            color = categoryColor,
            size = size,
            modifier = modifier,
            fill = fill
        )
        else -> CircleGlyph(
            color = categoryColor,
            size = size,
            modifier = modifier,
            fill = fill
        )
    }
}
