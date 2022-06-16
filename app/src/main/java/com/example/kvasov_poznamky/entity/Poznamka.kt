package com.example.kvasov_poznamky.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Poznamka
 *
 * @property nazov(nazov slpca)
 * @property text(nazov slpca)
 * @constructor Create empty Poznamka
 *
 * trieda Poznamka ako Entitu, ktoré budú uložené v tabuľke
 */
@Entity(tableName = "poznamky")
data class Poznamka(
    @ColumnInfo(name = "nazov") val nazov: String,
    @ColumnInfo(name = "text") val text: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}