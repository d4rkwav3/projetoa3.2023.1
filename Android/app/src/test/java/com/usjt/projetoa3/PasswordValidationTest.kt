package com.usjt.projetoa3

import com.usjt.projetoa3.model.PasswordValidation
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class PasswordValidationTest {
    val badPassword1 = "test$12" // Less than 8 characters
    val badPassword2 = "12345678" // Has only numbers
    val badPassword3 = "test35134" // Doesn't have special characters
    val badPassword4 = "#8@4*70!%" // Doesn't have alphabetic characters
    val goodPassword = "4ndr01dR0(K!$" // Good looking password

    // These hashs below are the SHA-256 from the passwords above
    // These hashs have to be lower cased because the test source generate then in upper case
    // and the Guava Hashing library generates hashs in lower case.
    val testHash1 = "1CFECC8E36C8B02920E5448687C29F08381A0CEF0B37466DC4161AFA27EADC70".lowercase()
    val testHash2 = "EF797C8118F02DFB649607DD5D3F8C7623048C9C063D532CC95C5ED7A898A64F".lowercase()
    val testHash3 = "BEC77B363B9B1623AC9BCD72D69E2E567697FD64985AE5FA7B7C313108B4658C".lowercase()
    val testHash4 = "6A6AB88E8E6359714B0C447E0A191B0BCEEFE299A89B4CB4D5F09315FE3BB07F".lowercase()
    val testHash5 = "61B3C3A8582BB2C58648002915E0E0E32466F0787DD0E9260487FE19DF26CEF6".lowercase()

    @Test
    fun passwordValidationTest() {
        val passwordValidation = PasswordValidation()

        assertFalse(passwordValidation.validatePassword(badPassword1))
        assertFalse(passwordValidation.validatePassword(badPassword2))
        assertFalse(passwordValidation.validatePassword(badPassword3))
        assertFalse(passwordValidation.validatePassword(badPassword4))
        assertTrue(passwordValidation.validatePassword(goodPassword))
    }

    @Test
    fun generatePasswordSha256Hash() {
        val passwordValidation = PasswordValidation()

        assertEquals(testHash1, passwordValidation.stringToHash(badPassword1))
        assertEquals(testHash2, passwordValidation.stringToHash(badPassword2))
        assertEquals(testHash3, passwordValidation.stringToHash(badPassword3))
        assertEquals(testHash4, passwordValidation.stringToHash(badPassword4))
        assertEquals(testHash5, passwordValidation.stringToHash(goodPassword))
    }
}