package com.fruitid.camera;

import android.content.Context;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.fruitid.ml.GemmaInference;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010 \u001a\u00020\nH\u0002J\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020\u0015J\u0006\u0010#\u001a\u00020\u0015J:\u0010$\u001a\u0004\u0018\u00010\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0018\b\u0002\u0010)\u001a\u0012\u0012\b\u0012\u00060*j\u0002`+\u0012\u0004\u0012\u00020\u00150\u0012H\u0086@\u00a2\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\u0015J\u001e\u0010.\u001a\u0002H/\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/00H\u0082@\u00a2\u0006\u0002\u00101R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010\u0011\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/fruitid/camera/CameraManager;", "", "context", "Landroid/content/Context;", "gemmaInference", "Lcom/fruitid/ml/GemmaInference;", "yuvConverter", "Lcom/fruitid/camera/YuvToBitmapConverter;", "(Landroid/content/Context;Lcom/fruitid/ml/GemmaInference;Lcom/fruitid/camera/YuvToBitmapConverter;)V", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "frameAnalyzer", "Lcom/fruitid/camera/FrameAnalyzer;", "imageAnalysis", "Landroidx/camera/core/ImageAnalysis;", "onDetections", "Lkotlin/Function1;", "", "Lcom/fruitid/ml/DetectionResult;", "", "getOnDetections", "()Lkotlin/jvm/functions/Function1;", "setOnDetections", "(Lkotlin/jvm/functions/Function1;)V", "onStandbyStateChange", "", "getOnStandbyStateChange", "setOnStandbyStateChange", "preview", "Landroidx/camera/core/Preview;", "getCameraExecutor", "pauseAnalysis", "resumeAnalysis", "shutdown", "startCamera", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "previewView", "Landroidx/camera/view/PreviewView;", "onError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/view/PreviewView;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopCamera", "await", "T", "Lcom/google/common/util/concurrent/ListenableFuture;", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"})
public final class CameraManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.ml.GemmaInference gemmaInference = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.camera.YuvToBitmapConverter yuvConverter = null;
    @org.jetbrains.annotations.NotNull()
    private static final android.util.Size PREVIEW_SIZE = null;
    @org.jetbrains.annotations.NotNull()
    private static final android.util.Size ANALYSIS_SIZE = null;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.lifecycle.ProcessCameraProvider cameraProvider;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.core.ImageAnalysis imageAnalysis;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.core.Preview preview;
    @org.jetbrains.annotations.Nullable()
    private java.util.concurrent.ExecutorService cameraExecutor;
    @org.jetbrains.annotations.Nullable()
    private com.fruitid.camera.FrameAnalyzer frameAnalyzer;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.util.List<com.fruitid.ml.DetectionResult>, kotlin.Unit> onDetections;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onStandbyStateChange;
    @org.jetbrains.annotations.NotNull()
    public static final com.fruitid.camera.CameraManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public CameraManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.fruitid.ml.GemmaInference gemmaInference, @org.jetbrains.annotations.NotNull()
    com.fruitid.camera.YuvToBitmapConverter yuvConverter) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<java.util.List<com.fruitid.ml.DetectionResult>, kotlin.Unit> getOnDetections() {
        return null;
    }
    
    public final void setOnDetections(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.util.List<com.fruitid.ml.DetectionResult>, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> getOnStandbyStateChange() {
        return null;
    }
    
    public final void setOnStandbyStateChange(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startCamera(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifecycleOwner, @org.jetbrains.annotations.NotNull()
    androidx.camera.view.PreviewView previewView, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit> onError, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<java.lang.Object> $completion) {
        return null;
    }
    
    public final void stopCamera() {
    }
    
    public final void pauseAnalysis() {
    }
    
    public final void resumeAnalysis() {
    }
    
    private final java.util.concurrent.ExecutorService getCameraExecutor() {
        return null;
    }
    
    public final void shutdown() {
    }
    
    private final <T extends java.lang.Object>java.lang.Object await(com.google.common.util.concurrent.ListenableFuture<T> $this$await, kotlin.coroutines.Continuation<? super T> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/fruitid/camera/CameraManager$Companion;", "", "()V", "ANALYSIS_SIZE", "Landroid/util/Size;", "getANALYSIS_SIZE", "()Landroid/util/Size;", "PREVIEW_SIZE", "getPREVIEW_SIZE", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.util.Size getPREVIEW_SIZE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.util.Size getANALYSIS_SIZE() {
            return null;
        }
    }
}