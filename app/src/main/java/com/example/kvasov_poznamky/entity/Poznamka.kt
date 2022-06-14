package com.example.kvasov_poznamky.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poznamky")
data class Poznamka(
    @ColumnInfo(name = "nazov") val nazov: String,
    @ColumnInfo(name = "text") val text: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}