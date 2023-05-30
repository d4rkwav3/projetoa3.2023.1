package com.usjt.projetoa3.data

import android.content.Context
import com.usjt.projetoa3.data.taco.FoodRepository
import com.usjt.projetoa3.data.taco.OfflineFoodRepository
import com.usjt.projetoa3.data.taco.TacoDb

interface AppContainer {
    val foodRepository: FoodRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val foodRepository: FoodRepository by lazy {
        OfflineFoodRepository(TacoDb.getDatabase(context).tacoDao())
    }
}