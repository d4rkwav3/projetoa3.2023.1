package com.usjt.projetoa3.data

data class NewUser(
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var confirmPassword: String? = null,
    var age: String? = null,
    var height: String? = null,
    var weight: String? = null,
    var userType: UserType = UserType.Free
)