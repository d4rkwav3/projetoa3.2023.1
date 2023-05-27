package com.usjt.projetoa3.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TacoDao {
    @Transaction
    @Query("SELECT * FROM foods " +
            "JOIN categories ON categoryId = categories.id " +
            "JOIN nutrients ON foodId = foods.id " +
            "WHERE foods.name LIKE :foodName")
    suspend fun findFoodByName(foodName: String): Flow<List<FoodInfo>>
}