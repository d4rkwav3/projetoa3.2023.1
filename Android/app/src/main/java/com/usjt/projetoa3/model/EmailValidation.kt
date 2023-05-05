package com.usjt.projetoa3.model

class EmailValidation : Validation() {
    val MIN_EMAIL_LENGTH = 10
    val MIN_USERNAME_LENGTH = 3
    val MIN_DOMAIN_LENGTH = 5
    val MAX_EMAIL_LENGTH = 128
    val EXPECTED_CHARS = arrayOf('@', '.')

    fun validateEmail(email: String): Boolean {
        val atSign = email.contains(this.EXPECTED_CHARS[0])
        val period = email.contains(this.EXPECTED_CHARS[1])
        val emailLength = when {
            email.length < 10 -> false
            email.length >= 200 -> false
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

            validDomain = domain.contains(this.EXPECTED_CHARS[1])
        }


        println(username)
        println(domain)

        return atSign && period && emailLength && username.length >= 3 && domain.length >= 5
    }
}