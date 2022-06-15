package com.example.kvasov_poznamky.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kvasov_poznamky.R
import com.example.kvasov_poznamky.adapter.RVAdapter
import com.example.kvasov_poznamky.entity.Poznamka
import com.example.kvasov_poznamky.interfaces.ClickInterface
import timber.log.Timber

class MainActivity : AppCompatActivity(), ClickInterface {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.i("onCreate called")

        val recyclerView : RecyclerView = findViewById(R.id.zoznam_poznamok)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = RVAdapter(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.poznamkyLiveData.observe(this, Observer {
            adapter.updateData(it)
        })


    }

    override fun onStart() {
        super.onStart()

        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()

        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()

        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()

        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()

        Timber.i("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()

        Timber.i("onRestart Called")
    }

    fun pridajPoznamku(view: View) {
        val intent = Intent(this, AddPoznamkyActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(poznamka: Poznamka) {
        viewModel.deletePoznamku(poznamka)
    }
}