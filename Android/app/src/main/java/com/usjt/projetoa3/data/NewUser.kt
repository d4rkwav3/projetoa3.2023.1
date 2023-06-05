package com.usjt.projetoa3.data

import com.usjt.projetoa3.data.user.User

data class NewUser(
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var passwordHash: String = "",
    var age: String = "",
    var height: String = "",
    var weight: String = "",
    var userType: UserType = UserType.Free,
    var isUserValid: Boolean = false
) {
    fun toUser(): User = User(
        id = 0,
        login = email,
        password = passwordHash,
        name = name,
        age = age.toByte(),
        height = height.toDouble(),
        weight = weight.toDouble()
    )

    fun isValid() : Boolean {
        return name.isNotBlank() &&
                email.isNotBlank() &&
                password.isNotBlank() &&
                confirmPassword.isNotBlank() &&
                age.isNotBlank() &&
                height.isNotBlank() &&
                weight.isNotBlank()
    }
}