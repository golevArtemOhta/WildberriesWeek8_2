package com.example.wildberriesweekfive

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wildberriesweekfive.databinding.SuperHeroItemBinding
import com.squareup.picasso.Picasso

class SuperHeroAdapter : RecyclerView.Adapter<SuperHeroAdapter.SuperHeroHolder>() {
    val SuperHeroesList = ArrayList<SuperHeroJSON>()

    class SuperHeroHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = SuperHeroItemBinding.bind(item)


        @SuppressLint("SetTextI18n")
        fun bind(superHero: SuperHeroJSON) = with(binding) {

            Picasso.with(itemView.context)
                .load(superHero.images.xs)
                .into(imAvatar);

            tvName.text = superHero.name

            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("name", superHero.name)
                bundle.putString("image", superHero.images.lg.toString())
                bundle.putString("gender", superHero.appearance.gender)
                bundle.putString("race", superHero.appearance.race)
                bundle.putString("fullName", superHero.biography.fullName)
                bundle.putString("placeOfBirth", superHero.biography.placeOfBirth)
                bundle.putString("publisher", superHero.biography.publisher)


                App.INSTANCE.router.navigateTo(Screens.SuperHeroItemScreen(bundle))
            }

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