package com.fruitid.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u001dJ\u0016\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003J\t\u0010\'\u001a\u00020(H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\n\u00a8\u0006)"}, d2 = {"Lcom/fruitid/domain/model/BoundingBox;", "", "x1", "", "y1", "x2", "y2", "(FFFF)V", "area", "getArea", "()F", "centerX", "getCenterX", "centerY", "getCenterY", "height", "getHeight", "width", "getWidth", "getX1", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "intersects", "threshold", "isValid", "toCanvasCoordinates", "canvasWidth", "canvasHeight", "toString", "", "app_release"})
public final class BoundingBox {
    private final float x1 = 0.0F;
    private final float y1 = 0.0F;
    private final float x2 = 0.0F;
    private final float y2 = 0.0F;
    
    public BoundingBox(float x1, float y1, float x2, float y2) {
        super();
    }
    
    public final float getX1() {
        return 0.0F;
    }
    
    public final float getY1() {
        return 0.0F;
    }
    
    public final float getX2() {
        return 0.0F;
    }
    
    public final float getY2() {
        return 0.0F;
    }
    
    public final float getWidth() {
        return 0.0F;
    }
    
    public final float getHeight() {
        return 0.0F;
    }
    
    public final float getCenterX() {
        return 0.0F;
    }
    
    public final float getCenterY() {
        return 0.0F;
    }
    
    public final float getArea() {
        return 0.0F;
    }
    
    public final boolean isValid() {
        return false;
    }
    
    public final boolean intersects(@org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.BoundingBox other, float threshold) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.BoundingBox toCanvasCoordinates(float canvasWidth, float canvasHeight) {
        return null;
    }
    
    public final float component1() {
        return 0.0F;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.BoundingBox copy(float x1, float y1, float x2, float y2) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}