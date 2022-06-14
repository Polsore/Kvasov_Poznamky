package com.example.kvasov_poznamky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pridajPoznamku(view: View) {
        val intent = Intent(this, AddPoznamkyActivity::class.java)
        startActivity(intent)
    }
}