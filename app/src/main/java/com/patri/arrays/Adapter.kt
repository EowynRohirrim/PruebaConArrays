package com.patri.arrays

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patri.arrays.database.entities.MovieEntity


class Adapter(var moviesList: List<MovieEntity> = emptyList()) : RecyclerView.Adapter<ViewHolder>() {
    //He cambiado de String a int

    fun updateList(list: List<MovieEntity>) {//Ahora es una lista de List<Entity>
        moviesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }
    override fun getItemCount() = moviesList.size
}
