package com.example.kvasov_poznamky.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kvasov_poznamky.R
import com.example.kvasov_poznamky.dialogs.SaveErrorDialog
import com.example.kvasov_poznamky.entity.Poznamka

/**
 * Add poznamky activity
 *
 * Obrazovka s polamy gde mozem zadat nazov a text poznamky
 */
class AddPoznamkyActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_poznamka)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val save : Button? = findViewById(R.id.save)

        save?.setOnClickListener {
            pridajPoznamku()
        }

    }

    /**
     * Pridaj poznamku
     * Tlacislo SAVE spusty tuto funkciu v ktorej do main obrazovky prida novu poznamky
     * Ak bude neco napisane vo vsetkych polach
     * Ak nie spusti save_error_dialog
     */
    private fun pridajPoznamku() {

        var nazovPoznamky: EditText = findViewById(R.id.meno_poznamky)
        var textPoznamky: EditText = findViewById(R.id.text_poznamky)

        val meno = nazovPoznamky.text.toString()
        val text = textPoznamky.text.toString()

        if (meno.isNotEmpty() && text.isNotEmpty()) {
            viewModel.addPoznamku(Poznamka(meno, text))

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            var save_error_dialog = SaveErrorDialog()

            save_error_dialog.show(supportFragmentManager, "save_error_dialog")
        }

    }
}