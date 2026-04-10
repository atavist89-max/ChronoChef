package com.fruitid.data.repository;

import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import com.fruitid.data.local.db.DetectionDao;
import com.fruitid.data.local.db.DetectionEntity;
import com.fruitid.data.local.nutrition.NutritionData;
import com.fruitid.domain.model.BoundingBox;
import com.fruitid.domain.model.Detection;
import com.fruitid.domain.model.FruitCategory;
import com.fruitid.domain.model.NutritionInfo;
import com.google.gson.Gson;
import kotlinx.coroutines.flow.Flow;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00110\u0019J\u000e\u0010\u001a\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\u0006\u0010\u001c\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u001fJ\f\u0010 \u001a\u00020\u0017*\u00020!H\u0002J\f\u0010\"\u001a\u00020!*\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/fruitid/data/repository/DetectionRepository;", "", "detectionDao", "Lcom/fruitid/data/local/db/DetectionDao;", "nutritionData", "Lcom/fruitid/data/local/nutrition/NutritionData;", "gson", "Lcom/google/gson/Gson;", "(Lcom/fruitid/data/local/db/DetectionDao;Lcom/fruitid/data/local/nutrition/NutritionData;Lcom/google/gson/Gson;)V", "clearAllHistory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDetection", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldDetections", "", "", "days", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetectionById", "Lcom/fruitid/domain/model/Detection;", "getDetectionHistory", "Lkotlinx/coroutines/flow/Flow;", "getHistoryCount", "getRecentDetections", "limit", "saveDetection", "detection", "(Lcom/fruitid/domain/model/Detection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDomainModel", "Lcom/fruitid/data/local/db/DetectionEntity;", "toEntity", "app_debug"})
public final class DetectionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.local.db.DetectionDao detectionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.local.nutrition.NutritionData nutritionData = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    @javax.inject.Inject()
    public DetectionRepository(@org.jetbrains.annotations.NotNull()
    com.fruitid.data.local.db.DetectionDao detectionDao, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.local.nutrition.NutritionData nutritionData, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.fruitid.domain.model.Detection>> getDetectionHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecentDetections(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.fruitid.domain.model.Detection>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDetectionById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.fruitid.domain.model.Detection> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveDetection(@org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.Detection detection, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteDetection(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteOldDetections(int days, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearAllHistory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHistoryCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    private final com.fruitid.domain.model.Detection toDomainModel(com.fruitid.data.local.db.DetectionEntity $this$toDomainModel) {
        return null;
    }
    
    private final com.fruitid.data.local.db.DetectionEntity toEntity(com.fruitid.domain.model.Detection $this$toEntity) {
        return null;
    }
}