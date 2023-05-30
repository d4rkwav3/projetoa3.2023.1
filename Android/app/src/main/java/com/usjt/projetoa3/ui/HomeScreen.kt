package com.usjt.projetoa3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.usjt.projetoa3.AppViewModelProvider


@Composable
fun CreateHomeScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navController: NavController? = null
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        val homeUiState by viewModel.homeUiState.collectAsState()

        Text(
            text = homeUiState.name,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = homeUiState.categoryId.toString(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}