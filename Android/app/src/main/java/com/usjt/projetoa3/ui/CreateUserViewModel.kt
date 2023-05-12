package com.usjt.projetoa3.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.usjt.projetoa3.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreateUserViewModel: ViewModel() {
    private var _user = MutableStateFlow(User())
    val userData: StateFlow<User> = _user.asStateFlow()

    var passwordConfirmation: Boolean? = null
    var tempAge by mutableStateOf("")
    var tempWeight by mutableStateOf("")
    var tempHeight by mutableStateOf("")

    fun setName(name: String) {
        _user.update { old -> old.copy(name = name) }
    }

    fun setPassword(password: String) {
        _user.update { old -> old.copy(password = password) }
    }

    fun confirmPassword(password: String) {
        passwordConfirmation = _user.value.password.contentEquals(password)
    }

    fun setEmail(email: String) {
        _user.update { old -> old.copy(email = email) }
    }

    fun setAge(age: String) {
        tempAge = age
//        _user.update { old -> old.copy(age = age.toInt()) }

    }

    fun setHeight(height: String) {
        tempHeight = height
//        _user.update { old -> old.copy(height = height.replace(",", ".").toDouble()) }
    }

    fun setWeight(weight: String) {
        tempWeight = weight
//        _user.update { old -> old.copy(weight = weight.replace(",", ".").toDouble()) }
    }
}