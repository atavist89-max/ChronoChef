package com.fruitid.ui.screens;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.layout.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.core.content.ContextCompat;
import com.fruitid.camera.CameraManager;
import com.fruitid.ml.DetectionResult;
import com.fruitid.ui.theme.*;
import com.fruitid.ui.viewmodel.CameraViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u001a0\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u00a8\u0006\f"}, d2 = {"CameraPermissionRequest", "", "onRequestPermission", "Lkotlin/Function0;", "CameraScreen", "onDetectionTap", "Lkotlin/Function1;", "Lcom/fruitid/ml/DetectionResult;", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/fruitid/ui/viewmodel/CameraViewModel;", "app_debug"})
public final class CameraScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void CameraScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.fruitid.ml.DetectionResult, kotlin.Unit> onDetectionTap, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.fruitid.ui.viewmodel.CameraViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CameraPermissionRequest(kotlin.jvm.functions.Function0<kotlin.Unit> onRequestPermission) {
    }
}