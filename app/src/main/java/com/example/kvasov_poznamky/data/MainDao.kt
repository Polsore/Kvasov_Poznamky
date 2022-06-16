package com.example.kvasov_poznamky.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kvasov_poznamky.entity.Poznamka

/**
 * Main dao
 *
 * @constructor Create empty Main dao
 *
 * MainDao pomôže triede Poznamka pracovať s objektmi
 */
@Dao
interface MainDao {
    /**
     * Get all data
     *
     * @return Vrati zoznam poznamok za id
     */
    @Query("SELECT * FROM poznamky order by id ASC")
    fun getAllData(): LiveData<List<Poznamka>>

    @Update
    fun update(poznamka: Poznamka)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(poznamka: Poznamka)

    @Delete
    fun delete(poznamka: Poznamka)
}