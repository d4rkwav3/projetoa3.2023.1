package com.usjt.projetoa3.data.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        User::class
    ],
    version = 1,
    exportSchema = false
)
abstract class UserDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var Instance: UserDb? = null

        fun getDatabase(context: Context): UserDb {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, UserDb::class.java, "user")
                    .allowMainThreadQueries()
                    .createFromAsset("user.db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}