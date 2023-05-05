package com.usjt.projetoa3

import com.usjt.projetoa3.model.EmailValidation
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EmailValidationTest() {

    @Test
    fun emailValidationTest() {
        val emailValidation = EmailValidation()
        val badEmail1 = "testemail.gmail.com"
        val badEmail2 = "@socialnetwork"
        val badEmail3 = "df@gmail.com"
        val goodEmail = "this_one_is_good@xyz.com"

        assertFalse(emailValidation.validateEmail(badEmail1))
        assertFalse(emailValidation.validateEmail(badEmail2))
        assertFalse(emailValidation.validateEmail(badEmail3))
        assertTrue(emailValidation.validateEmail(goodEmail))
    }
}