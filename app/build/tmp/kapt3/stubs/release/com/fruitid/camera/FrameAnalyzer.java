package com.fruitid.camera;

import android.graphics.Bitmap;
import android.os.SystemClock;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.fruitid.ml.DetectionResult;
import com.fruitid.ml.GemmaInference;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016J\u0006\u0010\'\u001a\u00020\u0014J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000eH\u0002J\u0006\u0010*\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010\u0010\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/fruitid/camera/FrameAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "inference", "Lcom/fruitid/ml/GemmaInference;", "converter", "Lcom/fruitid/camera/YuvToBitmapConverter;", "(Lcom/fruitid/ml/GemmaInference;Lcom/fruitid/camera/YuvToBitmapConverter;)V", "frameCount", "", "isStandby", "", "lastAnalysisTime", "", "lastBitmap", "Landroid/graphics/Bitmap;", "lastMotionTime", "onDetections", "Lkotlin/Function1;", "", "Lcom/fruitid/ml/DetectionResult;", "", "getOnDetections", "()Lkotlin/jvm/functions/Function1;", "setOnDetections", "(Lkotlin/jvm/functions/Function1;)V", "onMotionDetected", "Lkotlin/Function0;", "getOnMotionDetected", "()Lkotlin/jvm/functions/Function0;", "setOnMotionDetected", "(Lkotlin/jvm/functions/Function0;)V", "onStandbyStateChange", "getOnStandbyStateChange", "setOnStandbyStateChange", "scope", "Lkotlinx/coroutines/CoroutineScope;", "analyze", "imageProxy", "Landroidx/camera/core/ImageProxy;", "destroy", "detectMotion", "current", "reset", "Companion", "app_release"})
public final class FrameAnalyzer implements androidx.camera.core.ImageAnalysis.Analyzer {
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.ml.GemmaInference inference = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.camera.YuvToBitmapConverter converter = null;
    public static final int FRAME_SKIP = 3;
    public static final int MOTION_THRESHOLD = 5000;
    public static final long STANDBY_TIMEOUT_MS = 2500L;
    public static final int ANALYSIS_SIZE = 448;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private int frameCount = 0;
    private long lastAnalysisTime = 0L;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap lastBitmap;
    private long lastMotionTime;
    private boolean isStandby = false;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.util.List<com.fruitid.ml.DetectionResult>, kotlin.Unit> onDetections;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onStandbyStateChange;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onMotionDetected;
    @org.jetbrains.annotations.NotNull()
    public static final com.fruitid.camera.FrameAnalyzer.Companion Companion = null;
    
    @javax.inject.Inject()
    public FrameAnalyzer(@org.jetbrains.annotations.NotNull()
    com.fruitid.ml.GemmaInference inference, @org.jetbrains.annotations.NotNull()
    com.fruitid.camera.YuvToBitmapConverter converter) {
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
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnMotionDetected() {
        return null;
    }
    
    public final void setOnMotionDetected(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    public void analyze(@org.jetbrains.annotations.NotNull()
    androidx.camera.core.ImageProxy imageProxy) {
    }
    
    private final boolean detectMotion(android.graphics.Bitmap current) {
        return false;
    }
    
    public final void reset() {
    }
    
    public final void destroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/fruitid/camera/FrameAnalyzer$Companion;", "", "()V", "ANALYSIS_SIZE", "", "FRAME_SKIP", "MOTION_THRESHOLD", "STANDBY_TIMEOUT_MS", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}