package com.usjt.projetoa3.data

import com.usjt.projetoa3.data.user.User

// Classe de dados, serve exclusivamente para armazenar informações
data class Login(
    var email: String = "",
    var password: String = "",
    var passwordHash: String = ""
)