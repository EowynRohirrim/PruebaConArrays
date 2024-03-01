package com.patri.arrays

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.patri.arrays.database.entities.MovieEntity
import com.patri.arrays.databinding.ActivityMainBinding
import com.patri.arrays.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemLayoutBinding.bind(view)

    fun bind(movieItemResponse: MovieEntity) {

        binding.tv1.text= movieItemResponse.title

        binding.tv2.text = movieItemResponse.director


    }
}

