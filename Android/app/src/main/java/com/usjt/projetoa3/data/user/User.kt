package com.usjt.projetoa3.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.usjt.projetoa3.ui.LoginViewModel

@Entity(tableName = "usuarios")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val login: String,
    @ColumnInfo(name = "senha") val password: String,
    @ColumnInfo(name = "nomeUsuario") val name: String,
    @ColumnInfo(name = "idade") val age: Byte,
    @ColumnInfo(name = "peso") val weight: Double,
    @ColumnInfo(name = "altura") val height: Double
)