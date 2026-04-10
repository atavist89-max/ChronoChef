package com.fruitid.ml

import com.fruitid.domain.model.BoundingBox
import com.fruitid.domain.model.FruitCategory
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GemmaOutputParser @Inject constructor(
    private val gson: Gson
) {

    companion object {
        const val CONFIDENCE_THRESHOLD = 0.5f
        const val NMS_THRESHOLD = 0.5f
    }

    fun parseOutput(output: String): List<DetectionResult> {
        return try {
            val jsonArray = JsonParser.parseString(output) as? JsonArray
                ?: return emptyList()

            val detections = mutableListOf<DetectionResult>()

            jsonArray.forEach { element ->
                val obj = element as? JsonObject ?: return@forEach
                
                val label = obj.get("label")?.asString ?: return@forEach
                val scientificName = obj.get("scientific_name")?.asString ?: ""
                val confidence = obj.get("confidence")?.asFloat ?: 0f
                
                if (confidence < CONFIDENCE_THRESHOLD) return@forEach

                val bboxArray = obj.getAsJsonArray("bounding_box")
                if (bboxArray == null || bboxArray.size() < 4) return@forEach

                val bbox = BoundingBox(
                    x1 = bboxArray[0].asFloat,
                    y1 = bboxArray[1].asFloat,
                    x2 = bboxArray[2].asFloat,
                    y2 = bboxArray[3].asFloat
                )

                if (!bbox.isValid()) return@forEach

                val category = FruitCategory.fromLabel(label)

                detections.add(
                    DetectionResult(
                        label = label.capitalize(),
                        scientificName = scientificName,
                        boundingBox = bbox,
                        confidence = confidence,
                        category = category
                    )
                )
            }

            // Apply Non-Maximum Suppression
            applyNMS(detections)

        } catch (e: Exception) {
            emptyList()
        }
    }

    private fun applyNMS(detections: List<DetectionResult>): List<DetectionResult> {
        if (detections.size <= 1) return detections

        // Sort by confidence descending
        val sorted = detections.sortedByDescending { it.confidence }.toMutableList()
        val result = mutableListOf<DetectionResult>()

        while (sorted.isNotEmpty()) {
            val best = sorted.removeAt(0)
            result.add(best)

            // Remove overlapping detections
            sorted.removeAll { detection ->
                detection.boundingBox.intersects(best.boundingBox, NMS_THRESHOLD)
            }
        }

        return result
    }

    fun formatPrompt(): String {
        return """Detect all fruits in the image. 
            |Output a JSON array where each element has:
            |- "label": common fruit name (lowercase)
            |- "scientific_name": scientific binomial name
            |- "bounding_box": [x1, y1, x2, y2] normalized coordinates (0-1)
            |- "confidence": detection confidence (0-1)
            |Example: [{"label":"apple","scientific_name":"Malus domestica","bounding_box":[0.1,0.2,0.5,0.7],"confidence":0.95}]""".trimMargin()
    }

    private fun String.capitalize(): String {
        return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}
