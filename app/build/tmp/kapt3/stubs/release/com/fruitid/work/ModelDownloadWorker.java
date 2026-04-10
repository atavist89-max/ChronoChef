package com.fruitid.work;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.hilt.work.HiltWorker;
import androidx.work.*;
import com.fruitid.data.download.ModelDownloadManager;
import com.fruitid.data.local.prefs.SettingsPrefs;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B+\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/fruitid/work/ModelDownloadWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "downloadManager", "Lcom/fruitid/data/download/ModelDownloadManager;", "settingsPrefs", "Lcom/fruitid/data/local/prefs/SettingsPrefs;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/fruitid/data/download/ModelDownloadManager;Lcom/fruitid/data/local/prefs/SettingsPrefs;)V", "createForegroundInfo", "Landroidx/work/ForegroundInfo;", "progress", "", "createNotificationChannel", "", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"})
@androidx.hilt.work.HiltWorker()
public final class ModelDownloadWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.download.ModelDownloadManager downloadManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.local.prefs.SettingsPrefs settingsPrefs = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_NAME = "model_download";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "model_download_channel";
    public static final int NOTIFICATION_ID = 1001;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_URL = "url";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_SHA256 = "sha256";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_USE_MOBILE_DATA = "use_mobile_data";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROGRESS_BYTES = "progress_bytes";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROGRESS_TOTAL = "progress_total";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROGRESS_SPEED = "progress_speed";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROGRESS_STATE = "progress_state";
    @org.jetbrains.annotations.NotNull()
    public static final com.fruitid.work.ModelDownloadWorker.Companion Companion = null;
    
    @dagger.assisted.AssistedInject()
    public ModelDownloadWorker(@dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters params, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.download.ModelDownloadManager downloadManager, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.local.prefs.SettingsPrefs settingsPrefs) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    private final androidx.work.ForegroundInfo createForegroundInfo(java.lang.String progress) {
        return null;
    }
    
    private final void createNotificationChannel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/fruitid/work/ModelDownloadWorker$Companion;", "", "()V", "CHANNEL_ID", "", "KEY_SHA256", "KEY_URL", "KEY_USE_MOBILE_DATA", "NOTIFICATION_ID", "", "PROGRESS_BYTES", "PROGRESS_SPEED", "PROGRESS_STATE", "PROGRESS_TOTAL", "WORK_NAME", "createWorkRequest", "Landroidx/work/OneTimeWorkRequest;", "url", "sha256", "useMobileData", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.work.OneTimeWorkRequest createWorkRequest(@org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.NotNull()
        java.lang.String sha256, boolean useMobileData) {
            return null;
        }
    }
}