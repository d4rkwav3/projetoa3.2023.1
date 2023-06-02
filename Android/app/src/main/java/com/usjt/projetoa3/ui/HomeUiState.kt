package com.usjt.projetoa3.ui

import com.usjt.projetoa3.data.taco.Food

data class HomeUiState(
    val id: Int,
    val name: String,
    val categoryId: Int,
) {
    fun toFood(): Food = Food(
        id = id,
        name = name,
        categoryId = categoryId
    )
}