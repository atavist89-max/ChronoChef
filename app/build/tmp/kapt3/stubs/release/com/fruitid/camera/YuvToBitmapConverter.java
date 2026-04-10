package com.fruitid.camera;

import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/fruitid/camera/YuvToBitmapConverter;", "", "()V", "outputStream", "Ljava/io/ByteArrayOutputStream;", "convert", "Landroid/graphics/Bitmap;", "image", "Landroid/media/Image;", "rotationDegrees", "", "convertToRgbBytes", "", "rotateBitmap", "bitmap", "degrees", "app_release"})
public final class YuvToBitmapConverter {
    @org.jetbrains.annotations.NotNull()
    private final java.io.ByteArrayOutputStream outputStream = null;
    
    @javax.inject.Inject()
    public YuvToBitmapConverter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap convert(@org.jetbrains.annotations.NotNull()
    android.media.Image image, int rotationDegrees) {
        return null;
    }
    
    private final android.graphics.Bitmap rotateBitmap(android.graphics.Bitmap bitmap, int degrees) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] convertToRgbBytes(@org.jetbrains.annotations.NotNull()
    android.media.Image image) {
        return null;
    }
}