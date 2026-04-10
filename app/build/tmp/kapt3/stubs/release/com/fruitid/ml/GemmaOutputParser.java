package com.fruitid.ml;

import com.fruitid.domain.model.BoundingBox;
import com.fruitid.domain.model.FruitCategory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\nJ\f\u0010\r\u001a\u00020\n*\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/fruitid/ml/GemmaOutputParser;", "", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "applyNMS", "", "Lcom/fruitid/ml/DetectionResult;", "detections", "formatPrompt", "", "parseOutput", "output", "capitalize", "Companion", "app_release"})
public final class GemmaOutputParser {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    public static final float CONFIDENCE_THRESHOLD = 0.5F;
    public static final float NMS_THRESHOLD = 0.5F;
    @org.jetbrains.annotations.NotNull()
    public static final com.fruitid.ml.GemmaOutputParser.Companion Companion = null;
    
    @javax.inject.Inject()
    public GemmaOutputParser(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.fruitid.ml.DetectionResult> parseOutput(@org.jetbrains.annotations.NotNull()
    java.lang.String output) {
        return null;
    }
    
    private final java.util.List<com.fruitid.ml.DetectionResult> applyNMS(java.util.List<com.fruitid.ml.DetectionResult> detections) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatPrompt() {
        return null;
    }
    
    private final java.lang.String capitalize(java.lang.String $this$capitalize) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/fruitid/ml/GemmaOutputParser$Companion;", "", "()V", "CONFIDENCE_THRESHOLD", "", "NMS_THRESHOLD", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}