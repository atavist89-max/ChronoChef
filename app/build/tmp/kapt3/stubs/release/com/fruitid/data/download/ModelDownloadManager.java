package com.fruitid.data.download;

import android.content.Context;
import com.fruitid.data.local.prefs.SettingsPrefs;
import com.fruitid.data.repository.ModelRepository;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019J6\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b$\u0010%R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006&"}, d2 = {"Lcom/fruitid/data/download/ModelDownloadManager;", "", "context", "Landroid/content/Context;", "downloader", "Lcom/fruitid/data/download/ResumableDownloader;", "modelRepository", "Lcom/fruitid/data/repository/ModelRepository;", "settingsPrefs", "Lcom/fruitid/data/local/prefs/SettingsPrefs;", "(Landroid/content/Context;Lcom/fruitid/data/download/ResumableDownloader;Lcom/fruitid/data/repository/ModelRepository;Lcom/fruitid/data/local/prefs/SettingsPrefs;)V", "_downloadState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/fruitid/data/download/DownloadState;", "_progress", "Lcom/fruitid/data/download/DownloadProgress;", "downloadState", "Lkotlinx/coroutines/flow/StateFlow;", "getDownloadState", "()Lkotlinx/coroutines/flow/StateFlow;", "isCancelled", "", "progress", "getProgress", "cancelDownload", "", "getStorageRequiredMB", "", "reset", "resumeDownload", "startDownload", "Lkotlin/Result;", "url", "", "expectedSha256", "useMobileData", "startDownload-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class ModelDownloadManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.download.ResumableDownloader downloader = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.repository.ModelRepository modelRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.local.prefs.SettingsPrefs settingsPrefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.fruitid.data.download.DownloadState> _downloadState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.fruitid.data.download.DownloadState> downloadState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.fruitid.data.download.DownloadProgress> _progress = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.fruitid.data.download.DownloadProgress> progress = null;
    private boolean isCancelled = false;
    
    @javax.inject.Inject()
    public ModelDownloadManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.download.ResumableDownloader downloader, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.repository.ModelRepository modelRepository, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.local.prefs.SettingsPrefs settingsPrefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.fruitid.data.download.DownloadState> getDownloadState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.fruitid.data.download.DownloadProgress> getProgress() {
        return null;
    }
    
    public final void cancelDownload() {
    }
    
    public final void resumeDownload() {
    }
    
    public final long getStorageRequiredMB() {
        return 0L;
    }
    
    public final void reset() {
    }
}