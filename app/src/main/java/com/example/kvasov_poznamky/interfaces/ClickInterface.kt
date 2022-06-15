package com.example.kvasov_poznamky.interfaces

import com.example.kvasov_poznamky.entity.Poznamka

interface ClickInterface {
    fun onClick(poznamka: Poznamka)
}