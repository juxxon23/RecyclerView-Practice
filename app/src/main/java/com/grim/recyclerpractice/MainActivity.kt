package com.grim.recyclerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grim.recyclerpractice.models.SuperHero

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    val myAdapter: RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }
    fun setUpRecyclerView(){
        myRecyclerView = findViewById<RecyclerView>(R.id.rvSuperHero)
        myRecyclerView.setHasFixedSize(true)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myAdapter.RecyclerAdapter(getSuperHeros(), this)
        myRecyclerView.adapter = myAdapter
    }

    fun getSuperHeros(): MutableList<SuperHero> {
        var superheros: MutableList<SuperHero> = ArrayList()
        superheros.add(SuperHero("Spiderman", "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        superheros.add(SuperHero("Daredevil", "Marvel", "Matthew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        superheros.add(SuperHero("Wolverine", "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
        superheros.add(SuperHero("Batman", "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
        superheros.add(SuperHero("Thor", "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))
        superheros.add(SuperHero("Flash", "DC", "Jay Garrick", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"))
        superheros.add(SuperHero("Green Lantern", "DC", "Alan Scott", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"))
        superheros.add(SuperHero("Wonder Woman", "DC", "Princess Diana", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"))
        return superheros
    }
}