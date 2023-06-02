package com.usjt.projetoa3.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usjt.projetoa3.data.Login
import com.usjt.projetoa3.data.user.User
import com.usjt.projetoa3.data.user.UserRepository
import com.usjt.projetoa3.model.PasswordValidation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class LoginViewModel(val userRepo: UserRepository): ViewModel() {
    // Fluxo de dados mutável privado
    private val _loginState = MutableStateFlow(Login())
    // Fluxo de dados de apenas leitura
    val loginState: StateFlow<Login> = _loginState.asStateFlow()
    private val users = userRepo.getAllUsers()
    private val makeHash = PasswordValidation()


    fun setUserEmail(email: String = "") {
        _loginState.update { old -> Login(email = email, password = old.password) }
    }

    fun setUserPassword(password: String = "") {
        _loginState.update { old ->
            Login(
                passwordHash = makeHash.stringToHash(password),
                email = old.email,
                password = password)
        }
    }

    fun checkUser(): Boolean {
        println("${loginState.value.email} : ${loginState.value.passwordHash}")
        val dbUser = users.filter {
            it.login == _loginState.value.email &&
                    it.password == _loginState.value.passwordHash
        }
        println("dbUser ${dbUser.size}")
        return dbUser.size == 1
    }

    data class LoginUiState(
        val id: Int = 0,
        val login: String = "",
        val password: String = "",
        val name: String = "",
        val age: Byte = 0,
        val weight: Double = 0.0,
        val height: Double = 1.0
    )
}