package com.usjt.projetoa3.data.taco

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Category::class,
        Food::class,
        AminoAcids::class,
//        FattyAcids::class,
        Nutrients::class,
        Unit::class,
//        FoodInfo::class
    ],
    version = 1
)
abstract class TacoDb : RoomDatabase() {

    abstract fun tacoDao(): TacoDao

    companion object {
        @Volatile
        private var Instance: TacoDb? = null

        fun getDatabase(context: Context): TacoDb {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TacoDb::class.java, "taco_db")
                    .createFromAsset("taco.db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}