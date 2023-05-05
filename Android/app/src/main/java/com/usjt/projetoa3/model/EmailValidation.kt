package com.usjt.projetoa3.model

class EmailValidation: DataValidation() {
    private val MIN_EMAIL_LENGTH = 10
    private val MIN_USERNAME_LENGTH = 3
    private val MIN_DOMAIN_LENGTH = 5
    private val MAX_EMAIL_LENGTH = 128
    private val EXPECTED_CHARS = arrayOf('@', '.')

    fun validateEmail(email: String): Boolean {
        val atSign = email.contains(EXPECTED_CHARS[0])
        val emailLength = when {
            email.length < MIN_EMAIL_LENGTH -> false
            email.length >= MAX_EMAIL_LENGTH -> false
            else -> true
        }
        var username: String = ""
        var domain: String = ""
        var validUsername = false
        var validDomain = false

        if(atSign) {
            for((index, char) in email.withIndex()) {
                if(char == '@') {
                    username += email.substring(startIndex = 0, endIndex = index)
                    domain += email.substring(startIndex = index + 1, endIndex = email.length)
                }
            }

            validDomain = domain.contains(EXPECTED_CHARS[1]) && domain.length >= MIN_DOMAIN_LENGTH
            validUsername = username.length >= MIN_USERNAME_LENGTH
        }

        println("###############################")
        println("Contém arroba: $atSign")
        println("email maior que 10 caracteres: $emailLength")
        println("nome de usuário válido: $validUsername: $username")
        println("domínio válido: $validDomain: $domain")
        println("###############################")

        return atSign && emailLength && validUsername && validDomain
    }
}