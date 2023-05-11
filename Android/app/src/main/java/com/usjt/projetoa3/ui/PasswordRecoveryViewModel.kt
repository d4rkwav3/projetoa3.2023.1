package com.usjt.projetoa3.ui

import androidx.lifecycle.ViewModel
import com.usjt.projetoa3.data.Login
import com.usjt.projetoa3.data.Recover
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PasswordRecoveryViewModel : ViewModel() {
    // Fluxo de dados mutável privado
    private val _State = MutableStateFlow(Recover())
    // Fluxo de dados de apenas leitura
    val State: StateFlow<Recover> = _State.asStateFlow()
    val recoveryMessage = "Verifique a caixa de entrada do seu e-mail"

    fun setEmailForRecovery(email: String) {
        _State.update { Recover(email) }
    }
}