package com.usjt.projetoa3

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.usjt.projetoa3.data.TacoDao
import com.usjt.projetoa3.data.TacoDb
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TacoDbTest {

    private lateinit var tacoDao: TacoDao
    private lateinit var tacoDb: TacoDb

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()

        tacoDb = Room.inMemoryDatabaseBuilder(context, TacoDb::class.java)
            .allowMainThreadQueries()
            .build()
        tacoDao = tacoDb.tacoDao()
    }

    @After
    fun closeDb() {
        tacoDb.close()
    }
}