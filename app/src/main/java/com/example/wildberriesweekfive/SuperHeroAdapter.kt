package com.example.wildberriesweekfive

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wildberriesweekfive.databinding.SuperHeroItemBinding

class SuperHeroAdapter : RecyclerView.Adapter<SuperHeroAdapter.SuperHeroHolder>() {
    val SuperHeroesList = ArrayList<SuperHeroJSON>()


    class SuperHeroHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = SuperHeroItemBinding.bind(item)


        @SuppressLint("SetTextI18n")
        fun bind(superHero: SuperHeroJSON) = with(binding) {
            //imAvatar.setImageResource()
            tvName.text = superHero.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.super_hero_item, parent, false)
        return SuperHeroHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroHolder, position: Int) {
        holder.bind(SuperHeroesList[position])
    }

    override fun getItemCount(): Int {
        return SuperHeroesList.size
    }

    fun getSuperHeroesData(superHeroes: List<SuperHeroJSON>) {
        SuperHeroesList.addAll(superHeroes)
    }



}