package com.fruitid.data.repository;

import android.content.Context;
import android.os.StatFs;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006 "}, d2 = {"Lcom/fruitid/data/repository/ModelRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "modelFile", "Ljava/io/File;", "getModelFile", "()Ljava/io/File;", "tempModelFile", "getTempModelFile", "deleteModel", "", "deleteTempFile", "getAvailableStorageMB", "", "getDownloadedBytes", "getModelPath", "", "getModelSize", "getTempModelPath", "hasEnoughStorage", "", "isModelDownloaded", "memoryMapModel", "Ljava/nio/channels/FileChannel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveTempToFinal", "verifyModelChecksum", "expectedHash", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"})
public final class ModelRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODEL_FILE_NAME = "gemma-4-e2b-q4_0.tflite";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TEMP_MODEL_FILE_NAME = "model.tmp";
    public static final long REQUIRED_FREE_SPACE_MB = 5120L;
    public static final long MODEL_SIZE_MB = 2560L;
    @org.jetbrains.annotations.NotNull()
    public static final com.fruitid.data.repository.ModelRepository.Companion Companion = null;
    
    @javax.inject.Inject()
    public ModelRepository(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final java.io.File getModelFile() {
        return null;
    }
    
    private final java.io.File getTempModelFile() {
        return null;
    }
    
    public final boolean isModelDownloaded() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModelPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTempModelPath() {
        return null;
    }
    
    public final long getDownloadedBytes() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object verifyModelChecksum(@org.jetbrains.annotations.NotNull()
    java.lang.String expectedHash, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object moveTempToFinal(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    public final boolean hasEnoughStorage() {
        return false;
    }
    
    public final long getAvailableStorageMB() {
        return 0L;
    }
    
    public final void deleteTempFile() {
    }
    
    public final void deleteModel() {
    }
    
    public final long getModelSize() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object memoryMapModel(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.nio.channels.FileChannel> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/fruitid/data/repository/ModelRepository$Companion;", "", "()V", "MODEL_FILE_NAME", "", "MODEL_SIZE_MB", "", "REQUIRED_FREE_SPACE_MB", "TEMP_MODEL_FILE_NAME", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}