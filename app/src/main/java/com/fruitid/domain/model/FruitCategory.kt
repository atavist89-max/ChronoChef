package com.fruitid.domain.model

import androidx.compose.ui.graphics.Color

enum class FruitCategory(
    val displayName: String,
    val color: Color,
    val scientificFamilies: List<String>
) {
    POME(
        displayName = "Pome Fruits",
        color = Color(0xFF34A853),
        scientificFamilies = listOf("Rosaceae", "Malus", "Pyrus")
    ),
    CITRUS(
        displayName = "Citrus Fruits",
        color = Color(0xFFFBBC04),
        scientificFamilies = listOf("Rutaceae", "Citrus")
    ),
    TROPICAL(
        displayName = "Tropical Fruits",
        color = Color(0xFFEA4335),
        scientificFamilies = listOf("Musaceae", "Anacardiaceae", "Caricaceae")
    ),
    BERRY(
        displayName = "Berries",
        color = Color(0xFF9334E6),
        scientificFamilies = listOf("Rosaceae", "Ericaceae", "Vitaceae")
    ),
    STONE(
        displayName = "Stone Fruits",
        color = Color(0xFFFF6D01),
        scientificFamilies = listOf("Rosaceae", "Prunus")
    ),
    MELON(
        displayName = "Melons",
        color = Color(0xFF00BCD4),
        scientificFamilies = listOf("Cucurbitaceae")
    ),
    UNKNOWN(
        displayName = "Unknown",
        color = Color(0xFF9AA0A6),
        scientificFamilies = emptyList()
    );

    companion object {
        fun fromLabel(label: String): FruitCategory {
            return when (label.lowercase()) {
                "apple", "pear", "quince" -> POME
                "orange", "lemon", "lime", "grapefruit", "tangerine", "mandarin", "clementine" -> CITRUS
                "banana", "mango", "pineapple", "papaya", "passion fruit", "lychee", "dragon fruit" -> TROPICAL
                "strawberry", "blueberry", "raspberry", "blackberry", "cranberry", "grape" -> BERRY
                "peach", "plum", "cherry", "apricot", "nectarine" -> STONE
                "watermelon", "cantaloupe", "honeydew" -> MELON
                else -> UNKNOWN
            }
        }
    }
}
