package com.usjt.projetoa3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usjt.projetoa3.data.taco.Food
import com.usjt.projetoa3.data.taco.FoodRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(foodRepo: FoodRepository) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
        foodRepo.getFoodStream(256).map { HomeUiState(it.id, it.name, it.categoryId) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState(id = 1, name = "teste", categoryId = 1)
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

//    data class HomeUiState(val food: Food = Food(1, "teste", 1))
}