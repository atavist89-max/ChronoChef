package com.fruitid.domain.usecase;

import android.graphics.Bitmap;
import com.fruitid.ml.DetectionResult;
import com.fruitid.ml.GemmaInference;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/fruitid/domain/usecase/DetectFruitsUseCase;", "", "gemmaInference", "Lcom/fruitid/ml/GemmaInference;", "(Lcom/fruitid/ml/GemmaInference;)V", "invoke", "", "Lcom/fruitid/ml/DetectionResult;", "bitmap", "Landroid/graphics/Bitmap;", "app_release"})
public final class DetectFruitsUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.ml.GemmaInference gemmaInference = null;
    
    @javax.inject.Inject()
    public DetectFruitsUseCase(@org.jetbrains.annotations.NotNull()
    com.fruitid.ml.GemmaInference gemmaInference) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.fruitid.ml.DetectionResult> invoke(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return null;
    }
}