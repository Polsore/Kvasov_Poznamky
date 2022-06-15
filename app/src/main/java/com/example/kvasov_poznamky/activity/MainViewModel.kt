package com.example.kvasov_poznamky.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kvasov_poznamky.data.DataBase
import com.example.kvasov_poznamky.data.DataBaseRepozitory
import com.example.kvasov_poznamky.entity.Poznamka
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {
    val poznamkyLiveData: LiveData<List<Poznamka>>
    val repozitory: DataBaseRepozitory

    init{
        val mDao = DataBase.getDatabase(app).mainDao()
        repozitory = DataBaseRepozitory(mDao)
        poznamkyLiveData = repozitory.vsetkyPoznamky
    }

    fun updatePoznamku(poznamka: Poznamka) = viewModelScope.launch(Dispatchers.IO) {
        repozitory.update(poznamka)
    }

    fun addPoznamku(poznamka: Poznamka) = viewModelScope.launch(Dispatchers.IO) {
        repozitory.insert(poznamka)
    }

    fun deletePoznamku(poznamka: Poznamka) = viewModelScope.launch(Dispatchers.IO) {
        repozitory.delete(poznamka)
    }
}