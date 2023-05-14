package com.usjt.projetoa3.data

data class NewUser(
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var confirmPassword: String? = null,
    var age: Int? = null,
    var height: Double? = null,
    var weight: Double? = null,
    var userType: UserType? = null
) {
}