package com.usjt.projetoa3.data.taco

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TacoDao {
//    @Transaction
//    @Query("SELECT * FROM foods " +
//            "JOIN categories ON categoryId = categories.id " +
//            "JOIN nutrients ON foodId = foods.id " +
//            "WHERE foods.name LIKE :foodName")
//    fun findFoodByName(foodName: String): Flow<List<FoodInfo>>
//
//    @Transaction
//    @Query("SELECT * FROM foods " +
//            "JOIN categories ON categoryId = categories.id " +
//            "JOIN nutrients ON foodId = foods.id " +
//            "WHERE foods.id = :foodId")
//    fun findFoodInfoById(foodId: Int): Flow<FoodInfo>

    @Query("SELECT * FROM foods WHERE id = :id")
    fun findFoodById(id: Int): Flow<Food>
}