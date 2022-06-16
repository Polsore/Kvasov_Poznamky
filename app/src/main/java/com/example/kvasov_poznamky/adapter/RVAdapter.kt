package com.example.kvasov_poznamky.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kvasov_poznamky.R
import com.example.kvasov_poznamky.entity.Poznamka
import com.example.kvasov_poznamky.interfaces.ClickInterface
import java.util.ArrayList

/**
 * RV Adapter
 *
 * Aby pracovat z RecyclerView listom
 */
class RVAdapter(val clickInterface: ClickInterface) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    private val vsetkyPoznamky = ArrayList<Poznamka>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menoPoznamky : TextView = itemView.findViewById(R.id.meno_poznamky)
        val textPoznamky : TextView = itemView.findViewById(R.id.text_poznamky)
        val tlacidloDelete : ImageView = itemView.findViewById(R.id.obrazok_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.poznamka, parent, false))
        viewHolder.tlacidloDelete.setOnClickListener {
            clickInterface.onClick(vsetkyPoznamky[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.menoPoznamky.setText(vsetkyPoznamky.get(position).nazov)
        holder.textPoznamky.setText(vsetkyPoznamky.get(position).text)
    }

    override fun getItemCount(): Int {
        return vsetkyPoznamky.size
    }

    fun updateData(newList: List<Poznamka>) {
        vsetkyPoznamky.clear()
        vsetkyPoznamky.addAll(newList)
        notifyDataSetChanged()
    }

}