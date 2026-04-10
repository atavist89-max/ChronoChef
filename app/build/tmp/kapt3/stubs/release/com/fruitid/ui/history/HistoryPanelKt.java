package com.fruitid.ui.history;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import coil.request.ImageRequest;
import com.fruitid.domain.model.Detection;
import com.fruitid.ui.theme.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0003\u001aB\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003\u001a<\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003\u001a0\u0010\u0011\u001a\u00020\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a\u001e\u0010\u0018\u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0003\u00a8\u0006\u001a"}, d2 = {"EmptyHistory", "", "HistoryHeader", "isMultiSelectMode", "", "selectedCount", "", "onClearSelection", "Lkotlin/Function0;", "onDeleteSelected", "onSettingsClick", "HistoryItem", "detection", "Lcom/fruitid/domain/model/Detection;", "isSelected", "onClick", "onLongClick", "HistoryPanel", "onDetectionClick", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/fruitid/ui/history/HistoryViewModel;", "HistorySettingsDialog", "onDismiss", "app_release"})
public final class HistoryPanelKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HistoryPanel(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.fruitid.domain.model.Detection, kotlin.Unit> onDetectionClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.fruitid.ui.history.HistoryViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void HistoryHeader(boolean isMultiSelectMode, int selectedCount, kotlin.jvm.functions.Function0<kotlin.Unit> onClearSelection, kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteSelected, kotlin.jvm.functions.Function0<kotlin.Unit> onSettingsClick) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    private static final void HistoryItem(com.fruitid.domain.model.Detection detection, boolean isSelected, boolean isMultiSelectMode, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, kotlin.jvm.functions.Function0<kotlin.Unit> onLongClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void EmptyHistory() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void HistorySettingsDialog(kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, com.fruitid.ui.history.HistoryViewModel viewModel) {
    }
}