package com.usjt.projetoa3

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.usjt.projetoa3.data.taco.TacoDao
import com.usjt.projetoa3.data.taco.TacoDb
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

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
    @Throws(IOException::class)
    fun closeDb() {
        tacoDb.close()
    }

    @Test
    @Throws(IOException::class)
    fun daoSelect_selectFoodById() = runBlocking {
        val uva = tacoDao.findFoodInfoById(256).first()
        Log.d("SQLite", "${uva.food.id} : ${uva.food.name} : ${uva.category.id} : ${uva.category.name} : ${uva.nutrients.kJ}")
        assertEquals(uva.food.id, 256)
    }
}