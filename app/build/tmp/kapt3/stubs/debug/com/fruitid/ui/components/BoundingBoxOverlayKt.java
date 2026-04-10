package com.fruitid.ui.components;

import androidx.compose.foundation.layout.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.unit.Dp;
import com.fruitid.ml.DetectionResult;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0003\u001a,\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\b\u001a\u00020\u0004H\u0002\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0012"}, d2 = {"BoundingBoxOverlay", "", "detections", "", "Lcom/fruitid/ml/DetectionResult;", "modifier", "Landroidx/compose/ui/Modifier;", "BoxLabel", "detection", "DetectionClusterBadge", "count", "", "color", "Landroidx/compose/ui/graphics/Color;", "DetectionClusterBadge-bw27NRU", "(IJLandroidx/compose/ui/Modifier;)V", "drawChamferedBoundingBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "app_debug"})
public final class BoundingBoxOverlayKt {
    
    @androidx.compose.runtime.Composable()
    public static final void BoundingBoxOverlay(@org.jetbrains.annotations.NotNull()
    java.util.List<com.fruitid.ml.DetectionResult> detections, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void BoxLabel(com.fruitid.ml.DetectionResult detection, androidx.compose.ui.Modifier modifier) {
    }
    
    private static final void drawChamferedBoundingBox(androidx.compose.ui.graphics.drawscope.DrawScope $this$drawChamferedBoundingBox, com.fruitid.ml.DetectionResult detection) {
    }
}