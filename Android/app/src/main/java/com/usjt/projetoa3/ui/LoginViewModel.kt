package com.usjt.projetoa3.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.usjt.projetoa3.data.Login
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    // Fluxo de dados mutável privado
    private val _loginState = MutableStateFlow(Login())
    // Fluxo de dados de apenas leitura
    val loginState: StateFlow<Login> = _loginState.asStateFlow()

    fun setUserEmail(email: String = "") {
        _loginState.update { old -> Login(email = email, password = old.password) }
    }

    fun setUserPassword(password: String = "") {
        _loginState.update { old -> Login(password = password, email = old.email) }
    }

    fun login(login: Login): Boolean {
        Log.d("Login", "${login.email} : ${login.password}")
        return login.email == "teste" && login.password == "teste"
    }
}