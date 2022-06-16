package com.example.kvasov_poznamky.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kvasov_poznamky.entity.Poznamka

/**
 * Data base
 *
 * Trieda DataBase je zodpovedná za samotnú databázu a podľa toho ju vytvára
 */
@Database(entities = [Poznamka::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun mainDao(): MainDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "database-name"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}