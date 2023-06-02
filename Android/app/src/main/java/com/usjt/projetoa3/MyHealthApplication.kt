package com.usjt.projetoa3

import android.app.Application
import com.usjt.projetoa3.data.AppContainer
import com.usjt.projetoa3.data.AppDataContainer

class MyHealthApplication : Application() {

    /**
     *
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}