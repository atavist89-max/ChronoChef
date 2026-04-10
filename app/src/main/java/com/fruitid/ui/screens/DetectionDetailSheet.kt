package com.fruitid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fruitid.domain.model.Detection
import com.fruitid.domain.model.NutritionInfo
import com.fruitid.ui.components.CategoryGlyph
import com.fruitid.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetectionDetailSheet(
    detection: Detection,
    onDismiss: () -> Unit,
    onSaveToHistory: () -> Unit,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        containerColor = Surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp, max = 500.dp)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Drag handle
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(24.dp)
                        .height(4.dp)
                        .background(
                            color = TextTertiary.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(2.dp)
                        )
                )
            }

            // Large geometric glyph
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CategoryGlyph(
                    categoryColor = detection.category.color,
                    size = 48.dp,
                    fill = true
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Common name
            Text(
                text = detection.commonName,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            // Scientific name
            Text(
                text = detection.scientificName,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                color = TextSecondary,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Confidence
            Text(
                text = "${(detection.confidence * 100).toInt()}% confidence",
                fontSize = 14.sp,
                color = TextTertiary,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Nutrition section
            detection.nutritionInfo?.let { nutrition ->
                NutritionSection(nutrition)
                Spacer(modifier = Modifier.height(24.dp))
            }

            // Taxonomy
            detection.taxonomy?.let { taxonomy ->
                TaxonomySection(taxonomy)
                Spacer(modifier = Modifier.height(24.dp))
            }

            // Ripeness
            detection.ripenessDescription?.let { ripeness ->
                RipenessSection(ripeness)
                Spacer(modifier = Modifier.height(24.dp))
            }

            // Buttons
            Button(
                onClick = {
                    onSaveToHistory()
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        onDismiss()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                )
            ) {
                Text(
                    text = "Save to History",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        onDismiss()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Got it",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun NutritionSection(nutrition: NutritionInfo) {
    Column {
        Text(
            text = "Nutrition (per 100g)",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NutritionItem("Calories", "${nutrition.calories}", "kcal")
            NutritionItem("Sugar", "${nutrition.sugarGrams}", "g")
            NutritionItem("Fiber", "${nutrition.fiberGrams}", "g")
        }
    }
}

@Composable
private fun NutritionItem(label: String, value: String, unit: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )
        Text(
            text = unit,
            fontSize = 12.sp,
            color = TextTertiary
        )
        Text(
            text = label,
            fontSize = 14.sp,
            color = TextSecondary
        )
    }
}

@Composable
private fun TaxonomySection(taxonomy: String) {
    Column {
        Text(
            text = "Classification",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = taxonomy,
            fontSize = 14.sp,
            color = TextSecondary
        )
    }
}

@Composable
private fun RipenessSection(ripeness: String) {
    Column {
        Text(
            text = "Ripeness",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = ripeness,
            fontSize = 14.sp,
            color = TextSecondary
        )
    }
}
