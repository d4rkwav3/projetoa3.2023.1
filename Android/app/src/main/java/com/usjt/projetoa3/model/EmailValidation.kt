package com.usjt.projetoa3.model

class EmailValidation: DataValidation() {
    private val MIN_EMAIL_LENGTH = 10
    private val MIN_USERNAME_LENGTH = 3
    private val MIN_DOMAIN_LENGTH = 5
    private val MAX_EMAIL_LENGTH = 128
    private val EXPECTED_CHARS = arrayOf('@', '.')
    var isEmailInvalid: Boolean = false

    /*
    * o parametro basic executa uma validação menos precisa
    * o parametro verbose printa no console o resultado do teste
     */
    fun validateEmail(email: String, basic: Boolean = false, verbose: Boolean = false): Boolean {
        var trimedEmail = email.trim()
        var hasWhiteSpace = trimedEmail.contains(' ')
        val atSign = email.contains(EXPECTED_CHARS[0])
        val emailLength = when {
            email.length < MIN_EMAIL_LENGTH -> false
            email.length >= MAX_EMAIL_LENGTH -> false
            else -> true
        }

        if (hasWhiteSpace) {
            trimedEmail.filterNot { it == ' ' }
            hasWhiteSpace = trimedEmail.contains(' ')
        }

        var username: String = ""
        var domain: String = ""
        var twoCharAfterDot = ""
        var validUsername = false
        var validDomain = false
        var dotAfterAtSign = false
        var validFinal = false

        if (!basic) {
            if(atSign) {
                for((index, char) in email.withIndex()) {
                    if(char == '@') {
                        username += email.substring(startIndex = 0, endIndex = index)
                        domain += email.substring(startIndex = index + 1, endIndex = email.length)
                    }
                }

                validUsername = username.length >= MIN_USERNAME_LENGTH
                validDomain = domain.contains(EXPECTED_CHARS[1]) && domain.length >= MIN_DOMAIN_LENGTH
                dotAfterAtSign = domain.length >= 5 && domain.contains('.')
            }

            if(dotAfterAtSign) {
                twoCharAfterDot = domain.slice((domain.indexOf('.') + 1) until domain.length)
                validFinal = twoCharAfterDot.length >= 2
            }
        }

        if (verbose) {
            println("###############################")
            println("Contém espaço em branco: $hasWhiteSpace")
            println("Contém arroba: $atSign")
            println("email maior que 10 caracteres: $emailLength")
            if (!basic) {
                println("nome de usuário válido: $validUsername: $username")
                println("domínio válido: $validDomain: $domain")
                println("ponto depois do arroba: $dotAfterAtSign $twoCharAfterDot")
            }
            println("###############################")
        }

        isEmailInvalid = if (basic)
            !(atSign && emailLength && hasWhiteSpace)
        else
            !(atSign && emailLength && !hasWhiteSpace && validUsername && validDomain && dotAfterAtSign && validFinal)

        return isEmailInvalid
    }
}