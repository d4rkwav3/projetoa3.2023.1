package com.usjt.projetoa3.model

class EmailValidation : Validation() {
    val MIN_EMAIL_LENGTH = 10
    val MIN_USERNAME_LENGTH = 3
    val MIN_DOMAIN_LENGTH = 5
    val MAX_EMAIL_LENGTH = 200
    val EXPECTED_CHARS = arrayOf('@', '.')

    fun validateEmail(email: String): Boolean {
        var atSign = email.contains(this.EXPECTED_CHARS[0])
        var period = email.contains(this.EXPECTED_CHARS[1])
        var emailLength = when {
            email.length < this.MIN_EMAIL_LENGTH -> false
            email.length >= this.MAX_EMAIL_LENGTH -> false
            else -> true
        }

        return atSign && period && emailLength
    }
}