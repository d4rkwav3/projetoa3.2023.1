package com.usjt.projetoa3.model

import com.google.common.hash.Hashing
import java.nio.charset.StandardCharsets

class PasswordValidation: DataValidation() {
    private val MIN_PASSWORD_LENGTH: Int = 8
    private val MIN_QNTD_DIGITS: Int = 3
    private val MIN_QNTD_ALPHAS: Int = 3
    private val MIN_QNTD_SPECIAL: Int = 2
    private var passwordHash: String = ""
    var isPasswordInvalid: Boolean = false
    var isPasswordConfirmed: Boolean = false

    fun validatePassword(password: String): Boolean {
        var numberOfAlphaChars: Int = 0
        var numberOfDigits: Int = 0
        var numberOfSpecialChars: Int = 0
        val minimumLength: Boolean = password.length >= MIN_PASSWORD_LENGTH

        for(char in password) {
            if (char.isDigit()){
                numberOfDigits++
            } else if (char.isLetter()) {
                numberOfAlphaChars++
            } else if (char in allowedSymbols) {
                numberOfSpecialChars++
            }
        }

//        println("########################################")
//        println("Quantos caracteres numéricos: $numberOfDigits mínimo: $MIN_QNTD_DIGITS")
//        println("Quantos caracteres alfabéticos: $numberOfAlphaChars mínimo: $MIN_QNTD_ALPHAS")
//        println("Quantos caracteres especiais: $numberOfSpecialChars mínimo: $MIN_QNTD_SPECIAL")
//        println("Tem a quantidade mínima de caracteres? $minimumLength possui ${password.length}")
//        println("########################################")

        isPasswordInvalid = !(numberOfDigits >= MIN_QNTD_DIGITS && numberOfAlphaChars >= MIN_QNTD_ALPHAS && numberOfSpecialChars >= MIN_QNTD_SPECIAL)
        return isPasswordInvalid
    }

    fun stringToHash(password: String): String {
        passwordHash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString()
        return passwordHash
    }

    fun confirmPassword(password1: String, password2: String): Boolean {
//        println("1 senha digitada: $password1")
//        println("2 senha digitada: $password2")
        isPasswordConfirmed = password1 != password2
        return isPasswordConfirmed
    }
}