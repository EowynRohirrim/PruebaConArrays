package com.patri.arrays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.room.Room
import com.patri.arrays.database.MoviesDatabase
import com.patri.arrays.database.entities.MovieEntity
import com.patri.arrays.database.entities.toDatabase
import com.patri.arrays.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: com.patri.arrays.Adapter
    private lateinit var room : MoviesDatabase//Instancia objeto Room


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Construyo le objeto room
        room = Room.databaseBuilder(this, MoviesDatabase::class.java, "movies").build()
        //llenarBBDD()
        fillDatabase()
        initUI()
    }

    fun fillDatabase(){

        //Tenemos os arrays
        val titles = listOf<String>("X", "Y", "Z")
        val directors = listOf<String>("t", "d", "s")

        //Lista mutable
        val lista = mutableListOf<Movie>()

        /**for(i in 0.. <= titles.size-1){
        lista.add(Movie(titles[i].directors[i]))
        }
         * */

        // Llenar lista con instancias de Movie
        for (i in 0 until titles.size) {
            lista.add(Movie(titles[i], directors[i]))
            // Si necesitas convertir Movie a MovieEntity, puedes hacerlo aquí
        }

/**
        for (i in 0..titles.size - 1) {
            lista.add(Movie(titles[i], directors[i]))
        }**/
        //Sería MovieEntity(titles[i],directors[i]) si no piden clase Movie intermedia

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val entities: List<MovieEntity> = lista.map { it.toDatabase() }
                //y convertiria objeto movies a objeto entities

                room.getMovieDao().deleteAllMovieList()
                room.getMovieDao().insertAll(entities)
                Log.e("FillDatabase", "BIEN")
            } catch (e: Exception) {
                // Manejar errores aquí
                Log.e("FillDatabase", "Error: ${e.message}")
            }
        }

    }

    private fun initUI() {

        adapter = com.patri.arrays.Adapter()
        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter
    }
}