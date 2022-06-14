package com.example.kvasov_poznamky.data

import androidx.lifecycle.LiveData
import com.example.kvasov_poznamky.entity.Poznamka

class DataBaseRepozitory (private val mainDao: MainDao) {

    val vsetkyPoznamky: LiveData<List<Poznamka>> = mainDao.getAllData()

    suspend fun update(poznamka: Poznamka) {
        mainDao.update(poznamka)
    }

    suspend fun insert(poznamka: Poznamka) {
        mainDao.insert(poznamka)
    }

    suspend fun delete(poznamka: Poznamka) {
        mainDao.delete(poznamka)
    }
}