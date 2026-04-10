package com.fruitid.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\u000bH\u00c6\u0003J\t\u0010-\u001a\u00020\rH\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u007f\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u000205H\u00d6\u0001J\u0006\u00106\u001a\u000202J\t\u00107\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001d\u00a8\u00068"}, d2 = {"Lcom/fruitid/domain/model/Detection;", "", "id", "", "timestamp", "commonName", "", "scientificName", "confidence", "", "boundingBox", "Lcom/fruitid/domain/model/BoundingBox;", "category", "Lcom/fruitid/domain/model/FruitCategory;", "thumbnailPath", "nutritionInfo", "Lcom/fruitid/domain/model/NutritionInfo;", "taxonomy", "ripenessDescription", "(JJLjava/lang/String;Ljava/lang/String;FLcom/fruitid/domain/model/BoundingBox;Lcom/fruitid/domain/model/FruitCategory;Ljava/lang/String;Lcom/fruitid/domain/model/NutritionInfo;Ljava/lang/String;Ljava/lang/String;)V", "getBoundingBox", "()Lcom/fruitid/domain/model/BoundingBox;", "getCategory", "()Lcom/fruitid/domain/model/FruitCategory;", "getCommonName", "()Ljava/lang/String;", "getConfidence", "()F", "getId", "()J", "getNutritionInfo", "()Lcom/fruitid/domain/model/NutritionInfo;", "getRipenessDescription", "getScientificName", "getTaxonomy", "getThumbnailPath", "getTimestamp", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "isHighConfidence", "toString", "app_release"})
public final class Detection {
    private final long id = 0L;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String commonName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scientificName = null;
    private final float confidence = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.domain.model.BoundingBox boundingBox = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.domain.model.FruitCategory category = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String thumbnailPath = null;
    @org.jetbrains.annotations.Nullable()
    private final com.fruitid.domain.model.NutritionInfo nutritionInfo = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String taxonomy = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String ripenessDescription = null;
    
    public Detection(long id, long timestamp, @org.jetbrains.annotations.NotNull()
    java.lang.String commonName, @org.jetbrains.annotations.NotNull()
    java.lang.String scientificName, float confidence, @org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.BoundingBox boundingBox, @org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.FruitCategory category, @org.jetbrains.annotations.Nullable()
    java.lang.String thumbnailPath, @org.jetbrains.annotations.Nullable()
    com.fruitid.domain.model.NutritionInfo nutritionInfo, @org.jetbrains.annotations.Nullable()
    java.lang.String taxonomy, @org.jetbrains.annotations.Nullable()
    java.lang.String ripenessDescription) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCommonName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScientificName() {
        return null;
    }
    
    public final float getConfidence() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.BoundingBox getBoundingBox() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.FruitCategory getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThumbnailPath() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.fruitid.domain.model.NutritionInfo getNutritionInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTaxonomy() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRipenessDescription() {
        return null;
    }
    
    public final boolean isHighConfidence() {
        return false;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.BoundingBox component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.FruitCategory component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.fruitid.domain.model.NutritionInfo component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.domain.model.Detection copy(long id, long timestamp, @org.jetbrains.annotations.NotNull()
    java.lang.String commonName, @org.jetbrains.annotations.NotNull()
    java.lang.String scientificName, float confidence, @org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.BoundingBox boundingBox, @org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.FruitCategory category, @org.jetbrains.annotations.Nullable()
    java.lang.String thumbnailPath, @org.jetbrains.annotations.Nullable()
    com.fruitid.domain.model.NutritionInfo nutritionInfo, @org.jetbrains.annotations.Nullable()
    java.lang.String taxonomy, @org.jetbrains.annotations.Nullable()
    java.lang.String ripenessDescription) {
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