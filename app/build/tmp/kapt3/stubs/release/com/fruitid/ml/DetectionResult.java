package com.fruitid.ml;

import com.fruitid.domain.model.BoundingBox;
import com.fruitid.domain.model.FruitCategory;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\u0006\u0010 \u001a\u00020\u001cJ\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/fruitid/ml/DetectionResult;", "", "label", "", "scientificName", "boundingBox", "Lcom/fruitid/domain/model/BoundingBox;", "confidence", "", "category", "Lcom/fruitid/domain/model/FruitCategory;", "(Ljava/lang/String;Ljava/lang/String;Lcom/fruitid/domain/model/BoundingBox;FLcom/fruitid/domain/model/FruitCategory;)V", "getBoundingBox", "()Lcom/fruitid/domain/model/BoundingBox;", "getCategory", "()Lcom/fruitid/domain/model/FruitCategory;", "getConfidence", "()F", "getLabel", "()Ljava/lang/String;", "getScientificName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "isHighConfidence", "toString", "app_release"})
public final class DetectionResult {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String label = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scientificName = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.domain.model.BoundingBox boundingBox = null;
    private final float confidence = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.domain.model.FruitCategory category = null;
    
    public DetectionResult(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String scientificName, @org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.BoundingBox boundingBox, float confidence, @org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.FruitCategory category) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScientificName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.BoundingBox getBoundingBox() {
        return null;
    }
    
    public final float getConfidence() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.FruitCategory getCategory() {
        return null;
    }
    
    public final boolean isHighConfidence() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.BoundingBox component3() {
        return null;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.FruitCategory component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.ml.DetectionResult copy(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String scientificName, @org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.BoundingBox boundingBox, float confidence, @org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.FruitCategory category) {
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