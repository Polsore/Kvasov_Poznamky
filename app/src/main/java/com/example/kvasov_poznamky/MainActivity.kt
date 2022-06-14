package com.example.kvasov_poznamky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kvasov_poznamky.adapter.ClickInterface
import com.example.kvasov_poznamky.adapter.RVAdapter
import com.example.kvasov_poznamky.entity.Poznamka

class MainActivity : AppCompatActivity(), ClickInterface {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.zoznam_poznamok)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = RVAdapter(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.poznamkyLiveData.observe(this, Observer {
            adapter.updateData(it)
        })
    }

    fun pridajPoznamku(view: View) {
        val intent = Intent(this, AddPoznamkyActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(poznamka: Poznamka) {
        viewModel.deletePoznamku(poznamka)
    }
}