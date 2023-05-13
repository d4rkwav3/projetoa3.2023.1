package com.usjt.projetoa3.model

open class DataValidation {
    protected val allowedUpperChars = arrayOf(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'W', 'Z'
    )
    protected val allowedLowersChars = arrayOf(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'w', 'z'
    )
    protected val allowedSymbols = arrayOf('#', '!', '%', '$', '‘', '&', '+', '*', '–', '/', '=', '?', '^', '_', '`', '.', '{', '|', '}', '~')
    protected val allowedCharacters = allowedUpperChars + allowedLowersChars + allowedSymbols
    protected val MAX_TEXT_LENGTH: Int = 200
    protected val MIN_AGE: Int = 13
    protected val MAX_AGE: Int = 100
    protected val MIN_HEIGHT: Double = 1.0
    protected val MAX_HEIGHT: Double = 2.20
    protected val MIN_WEIGHT: Double = 45.0
    protected val MAX_WEIGHT: Double = 150.0
    var isNameInvalid: Boolean? = null
    var isAgeInvalid: Boolean? = null
    var isHeightInvalid: Boolean? = null
    var isWeightInvalid: Boolean? = null

    fun checkTextLength(text: String): Boolean {
        return text.length <= this.MAX_TEXT_LENGTH
    }

    fun validateHeight(height: Double): Boolean {
        return height in MIN_HEIGHT..MAX_HEIGHT
    }

    fun validateWeight(weight: Double): Boolean {
        return weight in MIN_WEIGHT..MAX_WEIGHT
    }
}