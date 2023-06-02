package com.usjt.projetoa3.data

import android.content.Context
import com.usjt.projetoa3.data.taco.FoodRepository
import com.usjt.projetoa3.data.taco.OfflineFoodRepository
import com.usjt.projetoa3.data.taco.TacoDb
import com.usjt.projetoa3.data.user.OfflineUserRepository
import com.usjt.projetoa3.data.user.UserDb
import com.usjt.projetoa3.data.user.UserRepository

interface AppContainer {
    val foodRepository: FoodRepository
    val userRepository: UserRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val foodRepository: FoodRepository by lazy {
        OfflineFoodRepository(TacoDb.getDatabase(context).tacoDao())
    }

    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(UserDb.getDatabase(context).userDao())
    }
}