package com.usjt.projetoa3.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.usjt.projetoa3.data.NewUser
import com.usjt.projetoa3.data.UserType
import com.usjt.projetoa3.data.user.UserRepository
import com.usjt.projetoa3.model.DataValidation
import com.usjt.projetoa3.model.EmailValidation
import com.usjt.projetoa3.model.PasswordValidation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreateUserViewModel(private val userRepo: UserRepository): ViewModel() {
    private var _user = MutableStateFlow(NewUser())
    val userData: StateFlow<NewUser> = _user.asStateFlow()

    private var _dataValidation = MutableStateFlow(DataValidation())
    val dataValidation: StateFlow<DataValidation> = _dataValidation.asStateFlow()

    private var _emailValidation = MutableStateFlow(EmailValidation())
    val emailValidation: StateFlow<EmailValidation> = _emailValidation.asStateFlow()

    private var _passwordValidation = MutableStateFlow(PasswordValidation())
    val passwordValidation: StateFlow<PasswordValidation> = _passwordValidation.asStateFlow()

    private var isUserValid = MutableStateFlow(
        _dataValidation.value.isAgeInvalid &&
                _dataValidation.value.isHeightInvalid &&
                _dataValidation.value.isNameInvalid &&
                _dataValidation.value.isWeightInvalid &&
                _emailValidation.value.isEmailInvalid &&
                _passwordValidation.value.isPasswordInvalid &&
                _passwordValidation.value.isPasswordConfirmed
    )

    fun setName(name: String) {
        _user.update { old -> old.copy(name = name) }
    }

    fun setPassword(password: String) {
        _user.update { old -> old.copy(password = password) }
    }

    fun confirmPassword(password: String) {
        _user.update {
                old -> old.copy(
            confirmPassword = password,
            passwordHash = passwordValidation.value.stringToHash(password)
        ) }
    }

    fun setEmail(email: String) {
        _user.update { old -> old.copy(email = email) }
    }

    fun setAge(age: String) {
        _user.update { old -> old.copy(age = age) }
    }

    fun setHeight(height: String) {
        _user.update { old -> old.copy(height = height) }

    }

    fun setWeight(weight: String) {
        _user.update { old -> old.copy(weight = weight) }
    }

    fun freeButtonClicked() {
        _user.update { old -> old.copy(userType = UserType.Free) }
        println(_user.value.userType.name)
    }

    fun paidButtonClicked() {
        _user.update { old -> old.copy(userType = UserType.Premium) }
        println(_user.value.userType.name)
    }

    fun getSelectedAccountType(type: String) {
//        println("Antes: ${_user.value.userType.name} : Recebido -> $type")
        if(type == "GRATUITA") {
            _user.update { old -> old.copy(userType = UserType.Free) }
        } else if (type == "PAGA") {
            _user.update { old -> old.copy(userType = UserType.Premium) }
        }
//        println("Depois: ${_user.value.userType.name} : Recebido -> $type")
    }

    suspend fun saveUser() {
//        Log.d("Cadastro", "${_user.value.password} : ${_user.value.passwordHash}")
        userRepo.insertUser(_user.value.toUser())
    }
}