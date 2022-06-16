package com.example.kvasov_poznamky.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.kvasov_poznamky.R
import com.example.kvasov_poznamky.activity.MainViewModel
import com.example.kvasov_poznamky.entity.Poznamka

/**
 * Save error dialog
 *
 * Create empty Save error dialog ak po
 */
class SaveErrorDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var mainView: View = inflater.inflate(R.layout.save_error, container, false)

        mainView.findViewById<View>(R.id.dialog_tlacidlo_ok).setOnClickListener {
            dismiss()
        }

        return mainView
    }
}