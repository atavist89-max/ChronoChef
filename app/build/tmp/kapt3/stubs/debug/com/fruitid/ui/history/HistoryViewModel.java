package com.fruitid.ui.history;

import android.content.Context;
import android.os.Environment;
import androidx.lifecycle.ViewModel;
import com.fruitid.data.local.prefs.SettingsPrefs;
import com.fruitid.data.repository.DetectionRepository;
import com.fruitid.domain.model.Detection;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.*;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u001dJ\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u000eR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/fruitid/ui/history/HistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "detectionRepository", "Lcom/fruitid/data/repository/DetectionRepository;", "settingsPrefs", "Lcom/fruitid/data/local/prefs/SettingsPrefs;", "(Landroid/content/Context;Lcom/fruitid/data/repository/DetectionRepository;Lcom/fruitid/data/local/prefs/SettingsPrefs;)V", "_isMultiSelectMode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_selectedIds", "", "", "allowMobileData", "Lkotlinx/coroutines/flow/StateFlow;", "getAllowMobileData", "()Lkotlinx/coroutines/flow/StateFlow;", "detections", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/fruitid/domain/model/Detection;", "getDetections", "()Lkotlinx/coroutines/flow/Flow;", "isMultiSelectMode", "selectedIds", "getSelectedIds", "clearAllHistory", "", "clearSelection", "deleteDetection", "id", "deleteSelected", "exportToCsv", "setAllowMobileData", "allow", "toggleSelection", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.repository.DetectionRepository detectionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.local.prefs.SettingsPrefs settingsPrefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.fruitid.domain.model.Detection>> detections = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isMultiSelectMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isMultiSelectMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Set<java.lang.Long>> _selectedIds = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.Set<java.lang.Long>> selectedIds = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> allowMobileData = null;
    
    @javax.inject.Inject()
    public HistoryViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.repository.DetectionRepository detectionRepository, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.local.prefs.SettingsPrefs settingsPrefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.fruitid.domain.model.Detection>> getDetections() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isMultiSelectMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.Set<java.lang.Long>> getSelectedIds() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getAllowMobileData() {
        return null;
    }
    
    public final void toggleSelection(long id) {
    }
    
    public final void clearSelection() {
    }
    
    public final void deleteSelected() {
    }
    
    public final void deleteDetection(long id) {
    }
    
    public final void clearAllHistory() {
    }
    
    public final void setAllowMobileData(boolean allow) {
    }
    
    public final void exportToCsv() {
    }
}