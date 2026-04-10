package com.fruitid.ml;

import android.content.Context;
import android.graphics.Bitmap;
import com.fruitid.data.repository.ModelRepository;
import dagger.hilt.android.qualifiers.ApplicationContext;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.gpu.GpuDelegate;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/fruitid/ml/GemmaInference;", "", "context", "Landroid/content/Context;", "modelRepository", "Lcom/fruitid/data/repository/ModelRepository;", "inputProcessor", "Lcom/fruitid/ml/GemmaInputProcessor;", "outputParser", "Lcom/fruitid/ml/GemmaOutputParser;", "(Landroid/content/Context;Lcom/fruitid/data/repository/ModelRepository;Lcom/fruitid/ml/GemmaInputProcessor;Lcom/fruitid/ml/GemmaOutputParser;)V", "gpuDelegate", "Lorg/tensorflow/lite/gpu/GpuDelegate;", "interpreter", "Lorg/tensorflow/lite/Interpreter;", "lock", "Ljava/lang/Object;", "close", "", "detect", "", "Lcom/fruitid/ml/DetectionResult;", "bitmap", "Landroid/graphics/Bitmap;", "detectFromProxy", "imageProxy", "Landroidx/camera/core/ImageProxy;", "getModelSize", "", "imageProxyToBitmap", "initialize", "", "isInitialized", "loadModelFile", "Ljava/nio/MappedByteBuffer;", "modelPath", "", "Companion", "app_release"})
public final class GemmaInference {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.repository.ModelRepository modelRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.ml.GemmaInputProcessor inputProcessor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.ml.GemmaOutputParser outputParser = null;
    @org.jetbrains.annotations.Nullable()
    private org.tensorflow.lite.Interpreter interpreter;
    @org.jetbrains.annotations.Nullable()
    private org.tensorflow.lite.gpu.GpuDelegate gpuDelegate;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object lock = null;
    public static final int MAX_DETECTIONS = 10;
    public static final int INPUT_SIZE = 448;
    @org.jetbrains.annotations.NotNull()
    public static final com.fruitid.ml.GemmaInference.Companion Companion = null;
    
    @javax.inject.Inject()
    public GemmaInference(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.repository.ModelRepository modelRepository, @org.jetbrains.annotations.NotNull()
    com.fruitid.ml.GemmaInputProcessor inputProcessor, @org.jetbrains.annotations.NotNull()
    com.fruitid.ml.GemmaOutputParser outputParser) {
        super();
    }
    
    public final boolean initialize() {
        return false;
    }
    
    public final boolean isInitialized() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.fruitid.ml.DetectionResult> detect(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.fruitid.ml.DetectionResult> detectFromProxy(@org.jetbrains.annotations.NotNull()
    androidx.camera.core.ImageProxy imageProxy) {
        return null;
    }
    
    private final android.graphics.Bitmap imageProxyToBitmap(androidx.camera.core.ImageProxy imageProxy) {
        return null;
    }
    
    public final void close() {
    }
    
    private final java.nio.MappedByteBuffer loadModelFile(java.lang.String modelPath) {
        return null;
    }
    
    public final long getModelSize() {
        return 0L;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/fruitid/ml/GemmaInference$Companion;", "", "()V", "INPUT_SIZE", "", "MAX_DETECTIONS", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}