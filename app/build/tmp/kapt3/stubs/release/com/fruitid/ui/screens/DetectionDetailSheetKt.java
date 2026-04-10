package com.fruitid.ui.screens;

import androidx.compose.foundation.layout.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import com.fruitid.domain.model.Detection;
import com.fruitid.domain.model.NutritionInfo;
import com.fruitid.ui.theme.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0003\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000bH\u0003\u001a\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000bH\u0003\u00a8\u0006\u0015"}, d2 = {"DetectionDetailSheet", "", "detection", "Lcom/fruitid/domain/model/Detection;", "onDismiss", "Lkotlin/Function0;", "onSaveToHistory", "modifier", "Landroidx/compose/ui/Modifier;", "NutritionItem", "label", "", "value", "unit", "NutritionSection", "nutrition", "Lcom/fruitid/domain/model/NutritionInfo;", "RipenessSection", "ripeness", "TaxonomySection", "taxonomy", "app_release"})
public final class DetectionDetailSheetKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void DetectionDetailSheet(@org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.Detection detection, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSaveToHistory, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void NutritionSection(com.fruitid.domain.model.NutritionInfo nutrition) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void NutritionItem(java.lang.String label, java.lang.String value, java.lang.String unit) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TaxonomySection(java.lang.String taxonomy) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void RipenessSection(java.lang.String ripeness) {
    }
}