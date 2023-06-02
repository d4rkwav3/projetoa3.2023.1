package com.usjt.projetoa3

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
//import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.usjt.projetoa3.ui.CreateUserViewModel
import com.usjt.projetoa3.ui.HomeViewModel
import com.usjt.projetoa3.ui.LoginViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            LoginViewModel(MyHealthApplication().container.userRepository)
        }
        initializer {
            CreateUserViewModel(MyHealthApplication().container.userRepository)
        }
        initializer {
            HomeViewModel(MyHealthApplication().container.foodRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [MyHealthApplication].
 */
fun CreationExtras.MyHealthApplication(): MyHealthApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as MyHealthApplication)