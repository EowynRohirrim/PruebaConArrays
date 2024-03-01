package com.patri.arrays.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.patri.arrays.Movie


/**                             Tabla del Recycler View                  **/
@Entity(tableName="movie_table")
data class MovieEntity(// Es como crear una tabla en SQL

    //Clave primaria
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0, //el primer registro que mete es cero (estilo lista)
    @ColumnInfo(name = "title") val title: String,

    @ColumnInfo(name  = "director") val director: String,

    )

//Mapeo
fun Movie.toDatabase() = MovieEntity(title = title,
    director = director)


