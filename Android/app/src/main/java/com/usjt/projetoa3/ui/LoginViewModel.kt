package com.usjt.projetoa3.ui

import androidx.lifecycle.ViewModel
import com.usjt.projetoa3.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    // Fluxo de dados mutável privado
    private val _loginState = MutableStateFlow(User())
    // Fluxo de dados de apenas leitura
    val loginState: StateFlow<User> = _loginState.asStateFlow()

    fun setUserEmail(email: String = "") {
        _loginState.update { User -> User(email = email, password = User.password) }
    }

    fun setUserPassword(password: String = "") {
        _loginState.update { User -> User(password = password, email = User.email) }
    }
}