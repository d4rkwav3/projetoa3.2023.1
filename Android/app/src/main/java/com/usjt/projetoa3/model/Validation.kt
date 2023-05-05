package com.usjt.projetoa3.model

open class Validation {
    val allowedUpperChars = arrayOf(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'W', 'Z'
    )
    val allowedLowersChars = arrayOf(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'w', 'z'
    )
    val allowedSymbols = arrayOf('#', '!', '%', '$', '‘', '&', '+', '*', '–', '/', '=', '?', '^', '_', '`', '.', '{', '|', '}', '~')

    val allowedCharacters = allowedUpperChars + allowedLowersChars + allowedSymbols

    val MAX_TEXT_LENGTH: Int = 200

    fun checkTextLength(text: String): Boolean {
        return text.length <= this.MAX_TEXT_LENGTH
    }

}