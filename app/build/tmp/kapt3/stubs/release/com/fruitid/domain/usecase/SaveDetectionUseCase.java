package com.fruitid.domain.usecase;

import com.fruitid.data.local.nutrition.NutritionData;
import com.fruitid.data.repository.DetectionRepository;
import com.fruitid.domain.model.Detection;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086B\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/fruitid/domain/usecase/SaveDetectionUseCase;", "", "detectionRepository", "Lcom/fruitid/data/repository/DetectionRepository;", "nutritionData", "Lcom/fruitid/data/local/nutrition/NutritionData;", "(Lcom/fruitid/data/repository/DetectionRepository;Lcom/fruitid/data/local/nutrition/NutritionData;)V", "invoke", "", "detection", "Lcom/fruitid/domain/model/Detection;", "(Lcom/fruitid/domain/model/Detection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class SaveDetectionUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.repository.DetectionRepository detectionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.local.nutrition.NutritionData nutritionData = null;
    
    @javax.inject.Inject()
    public SaveDetectionUseCase(@org.jetbrains.annotations.NotNull()
    com.fruitid.data.repository.DetectionRepository detectionRepository, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.local.nutrition.NutritionData nutritionData) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.fruitid.domain.model.Detection detection, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
}