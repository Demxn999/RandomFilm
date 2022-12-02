package com.example.randomfilmk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*
class MainActivity : AppCompatActivity() {
    lateinit var movies : ArrayList<String>;
    val r = Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movies = resources.getStringArray(R.array.movies).toCollection(ArrayList())
        defaultMovie()
    }

    private fun defaultMovie() {
        val tvTitle = findViewById<TextView>(R.id.title)
        tvTitle.text =  movies[0]
        movies.removeAt(0)
    }

    fun onNextClick(view: View) {
        if (movies.isEmpty()) {
            val tvTitle = findViewById<TextView>(R.id.title)
            tvTitle.text =  "Фильмы закончлись"
        } else
        {
            val tvTitle = findViewById<TextView>(R.id.title)
            val index = r.nextInt(movies.size)
            tvTitle.text= movies[index]
            movies.removeAt(index)
        }
    }
    fun onClearClick(view: View) {
        movies = resources.getStringArray(R.array.movies).toCollection(ArrayList())
        defaultMovie()
    }
}