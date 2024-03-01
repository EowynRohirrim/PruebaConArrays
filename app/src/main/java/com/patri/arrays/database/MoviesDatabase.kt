package com.patri.arrays.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.patri.arrays.database.dao.MoviesDao
import com.patri.arrays.database.entities.MovieEntity


//Es un array con todas las tablas, con tantas clases entities como tablas tenga
@Database(entities = [MovieEntity::class], version = 1) //El 1 es un control de versiones, que ahora no se va a usar
abstract class MoviesDatabase: RoomDatabase() {

    //Hay dos entities pues dos funciones, una por cada tabla
    abstract fun getMovieDao(): MoviesDao

    //son getter porque es para coger información de la tabla de datos

}