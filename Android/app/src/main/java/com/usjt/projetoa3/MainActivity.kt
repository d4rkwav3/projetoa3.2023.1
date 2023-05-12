package com.usjt.projetoa3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.usjt.projetoa3.ui.CreateLoginScreen
import com.usjt.projetoa3.ui.CreateNewUserScreen
import com.usjt.projetoa3.ui.CreateRecoveryScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppStart()
        }
    }
}

@Composable
fun AppStart() {
    val navigation = rememberNavController()

    NavHost(
        navController = navigation,
        startDestination = Router.Login.name,
    ) {
        composable(route = Router.Login.name) {
            CreateLoginScreen(navController = navigation)
        }
        composable(route = Router.Recovery.name) {
            CreateRecoveryScreen(navController = navigation)
        }
        composable(route = Router.NewAccount.name) {
            CreateNewUserScreen(navController = navigation)
        }
    }

}

