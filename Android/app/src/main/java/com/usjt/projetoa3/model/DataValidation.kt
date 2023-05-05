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
    protected val MIN_HEIGTH: Double = 1.0
    protected val MAX_HEIGTH: Double = 2.20
    protected val MIN_WEIGTH: Double = 45.0
    protected val MAX_WEIGTH: Double = 150.0

    fun checkTextLength(text: String): Boolean {
        return text.length <= this.MAX_TEXT_LENGTH
    }

}