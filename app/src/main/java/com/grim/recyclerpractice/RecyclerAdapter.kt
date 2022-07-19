package com.grim.recyclerpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.grim.recyclerpractice.models.SuperHero
import com.squareup.picasso.Picasso

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var superheros: MutableList<SuperHero> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(superheros: MutableList<SuperHero>, context: Context) {
        this.superheros = superheros
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheros[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return superheros.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val superHeroName = view.findViewById<TextView>(R.id.tvSuperHero)
        val realName = view.findViewById<TextView>(R.id.tvRealName)
        val publisher = view.findViewById<TextView>(R.id.tvPublisher)
        val picture = view.findViewById<ImageView>(R.id.ivPicture)

        fun bind(superhero: SuperHero, context: Context) {
            superHeroName.text = superhero.superHero
            realName.text = superhero.realName
            publisher.text = superhero.publisher
            // Show superhero details item on click
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, superhero.superHero, Toast.LENGTH_SHORT).show() })
            picture.loadURL(superhero.picture)
        }
        fun ImageView.loadURL(url: String) {
            Picasso.get().load(url).into(this)
        }
    }
}