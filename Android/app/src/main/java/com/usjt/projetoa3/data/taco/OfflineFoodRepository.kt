package com.usjt.projetoa3.data.taco

import kotlinx.coroutines.flow.Flow

class OfflineFoodRepository(private val tacoDao: TacoDao) : FoodRepository {
//    override fun getAllFoodsStream(foodName: String): Flow<List<FoodInfo>> = tacoDao.findFoodByName(foodName)
//
//    override fun getFoodInfoStream(id: Int): Flow<FoodInfo?> = tacoDao.findFoodInfoById(id)

    override fun getFoodStream(id: Int): Flow<Food> = tacoDao.findFoodById(id)
}