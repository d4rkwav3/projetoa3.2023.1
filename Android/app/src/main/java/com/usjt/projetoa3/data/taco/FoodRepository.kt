package com.usjt.projetoa3.data.taco

import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    // Pega todos os itens de uma fonte de dados
//    fun getAllFoodsStream(foodName: String): Flow<List<FoodInfo>>
//
//    // Pega um item pelo id
//    fun getFoodInfoStream(id: Int): Flow<FoodInfo?>

    fun getFoodStream(id: Int): Flow<Food>
}