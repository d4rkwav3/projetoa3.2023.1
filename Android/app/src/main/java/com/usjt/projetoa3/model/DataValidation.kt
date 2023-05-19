package com.usjt.projetoa3.model

import kotlin.NumberFormatException

open class DataValidation {
    protected val allowedUpperChars = arrayOf(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'W', 'Z'
    )
    protected val allowedLowersChars = arrayOf(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'w', 'z'
    )
    protected val allowedSymbols = arrayOf('@','#', '!', '%', '$', '‘', '&', '+', '*', '–', '/', '=', '?', '^', '_', '`', '.', '{', '|', '}', '~')
    protected val allowedCharacters = allowedUpperChars + allowedLowersChars + allowedSymbols
    protected val MAX_TEXT_LENGTH: Int = 200
    protected val MIN_AGE: Int = 13
    protected val MAX_AGE: Int = 100
    protected val MIN_HEIGHT: Double = 1.0
    protected val MAX_HEIGHT: Double = 2.20
    protected val MIN_WEIGHT: Double = 45.0
    protected val MAX_WEIGHT: Double = 150.0

    var isNameInvalid: Boolean = false
    var isAgeInvalid: Boolean = false
    var isHeightInvalid: Boolean = false
    var isWeightInvalid: Boolean = false

    fun checkTextLength(text: String): Boolean {
        return text.length <= this.MAX_TEXT_LENGTH
    }

    fun validateHeight(height: String): Boolean {
        val heightAsDouble: Double = try {
            height.toDouble()
        } catch (nf: NumberFormatException) {
            0.0
        }
        isHeightInvalid = heightAsDouble !in MIN_HEIGHT..MAX_HEIGHT
        return isHeightInvalid
    }

    fun validateWeight(weight: String): Boolean {
        val weightToDouble: Double = try {
            weight.toDouble()
        } catch (nf: NumberFormatException) {
            0.0
        }
        isWeightInvalid = weightToDouble !in MIN_WEIGHT..MAX_WEIGHT
        return isWeightInvalid
    }

    fun validateAge(age: String): Boolean {
        val ageToInt: Int = try {
            age.toInt()
        } catch (nf: NumberFormatException) {
            0
        }
        isAgeInvalid = ageToInt !in MIN_AGE..MAX_AGE
        return isAgeInvalid
    }
    fun validateName(name: String): Boolean {
        isNameInvalid = name.length < 3
        return isNameInvalid
    }
}