package com.fruitid.ml;

import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.media.Image;
import android.util.Size;
import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/fruitid/ml/GemmaInputProcessor;", "", "()V", "yuvBuffer", "", "bitmapToFloatArray", "", "bitmap", "Landroid/graphics/Bitmap;", "createInputBuffer", "Ljava/nio/ByteBuffer;", "imageProxyToBitmap", "imageProxy", "Landroidx/camera/core/ImageProxy;", "preprocessBitmap", "preprocessImage", "resizeBitmap", "width", "", "height", "rotateBitmap", "degrees", "", "yuvToRgb", "image", "Landroid/media/Image;", "rotationDegrees", "yuvToRgbNative", "", "yuv", "rgb", "", "Companion", "app_debug"})
public final class GemmaInputProcessor {
    public static final int INPUT_SIZE = 448;
    public static final float NORMALIZATION_MEAN = 127.5F;
    public static final float NORMALIZATION_STD = 127.5F;
    @org.jetbrains.annotations.NotNull()
    private final byte[] yuvBuffer = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.fruitid.ml.GemmaInputProcessor.Companion Companion = null;
    
    @javax.inject.Inject()
    public GemmaInputProcessor() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final float[] preprocessImage(@org.jetbrains.annotations.NotNull()
    androidx.camera.core.ImageProxy imageProxy) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final float[] preprocessBitmap(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final android.graphics.Bitmap imageProxyToBitmap(androidx.camera.core.ImageProxy imageProxy) {
        return null;
    }
    
    private final android.graphics.Bitmap yuvToRgb(android.media.Image image, int rotationDegrees) {
        return null;
    }
    
    private final void yuvToRgbNative(byte[] yuv, int[] rgb, int width, int height) {
    }
    
    private final android.graphics.Bitmap resizeBitmap(android.graphics.Bitmap bitmap, int width, int height) {
        return null;
    }
    
    private final android.graphics.Bitmap rotateBitmap(android.graphics.Bitmap bitmap, float degrees) {
        return null;
    }
    
    private final float[] bitmapToFloatArray(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.nio.ByteBuffer createInputBuffer(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/fruitid/ml/GemmaInputProcessor$Companion;", "", "()V", "INPUT_SIZE", "", "NORMALIZATION_MEAN", "", "NORMALIZATION_STD", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}