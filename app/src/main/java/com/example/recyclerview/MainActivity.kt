package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superherolist = listOf<Superhero>(
            Superhero(
                R.drawable.antman,
                "Ant-Man",
                "lorem lipsum lorem lipsum lorem lipsum"
            ),

        Superhero(
            R.drawable.hulk,
            "Hulk",
            "lorem lipsum lorem lipsum lorem lipsum"
            ),

        Superhero(
            R.drawable.loki,
            "Loki",
            "lorem lipsum lorem lipsum lorem lipsum"
            ),

        Superhero(
            R.drawable.ironman,
            "Iron-Man",
            "lorem lipsum lorem lipsum lorem lipsum"
            ),

        Superhero(
            R.drawable.blackpanther,
            "Black-Panther",
            "lorem lipsum lorem lipsum lorem lipsum"
            ),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this, superherolist){
            val intent = Intent (this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}