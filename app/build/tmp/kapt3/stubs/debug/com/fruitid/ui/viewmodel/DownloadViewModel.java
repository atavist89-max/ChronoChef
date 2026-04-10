package com.fruitid.ui.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.fruitid.BuildConfig;
import com.fruitid.data.download.DownloadProgress;
import com.fruitid.data.download.DownloadState;
import com.fruitid.data.download.ModelDownloadManager;
import com.fruitid.data.local.prefs.SettingsPrefs;
import com.fruitid.data.repository.ModelRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/fruitid/ui/viewmodel/DownloadViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "downloadManager", "Lcom/fruitid/data/download/ModelDownloadManager;", "modelRepository", "Lcom/fruitid/data/repository/ModelRepository;", "settingsPrefs", "Lcom/fruitid/data/local/prefs/SettingsPrefs;", "(Landroid/app/Application;Lcom/fruitid/data/download/ModelDownloadManager;Lcom/fruitid/data/repository/ModelRepository;Lcom/fruitid/data/local/prefs/SettingsPrefs;)V", "downloadProgress", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/fruitid/data/download/DownloadProgress;", "getDownloadProgress", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "Lcom/fruitid/data/download/DownloadState;", "getUiState", "canResume", "", "cancelDownload", "", "getRequiredStorage", "", "resumeDownload", "retryDownload", "retryFromBeginning", "startDownload", "useMobileData", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DownloadViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.download.ModelDownloadManager downloadManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.repository.ModelRepository modelRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.local.prefs.SettingsPrefs settingsPrefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.fruitid.data.download.DownloadState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.fruitid.data.download.DownloadProgress> downloadProgress = null;
    
    @javax.inject.Inject()
    public DownloadViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.download.ModelDownloadManager downloadManager, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.repository.ModelRepository modelRepository, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.local.prefs.SettingsPrefs settingsPrefs) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.fruitid.data.download.DownloadState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.fruitid.data.download.DownloadProgress> getDownloadProgress() {
        return null;
    }
    
    public final void startDownload(boolean useMobileData) {
    }
    
    public final void cancelDownload() {
    }
    
    public final void resumeDownload() {
    }
    
    public final void retryDownload() {
    }
    
    public final void retryFromBeginning() {
    }
    
    public final boolean canResume() {
        return false;
    }
    
    public final long getRequiredStorage() {
        return 0L;
    }
}