package com.example.wildberriesweekfive

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wildberriesweekfive.databinding.FragmentSuperHeroItemBinding
import com.example.wildberriesweekfive.databinding.SuperHeroItemBinding
import com.squareup.picasso.Picasso


class SuperHeroItemFragment : Fragment() {
    lateinit var binding: FragmentSuperHeroItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuperHeroItemBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        val name = bundle?.getString("name")
        val image = bundle?.getString("image")
        val gender = bundle?.getString("gender")
        val race = bundle?.getString("race")
        val fullName = bundle?.getString("fullName")
        val placeOfBirth = bundle?.getString("placeOfBirth")
        val publisher = bundle?.getString("publisher")

        Picasso.with(context)
            .load(image)
            .into(binding.imageView);


        with(binding){
            tvNameSecondFragment.text = name
            tvGender.text = "Gender: $gender"
            tvRace.text = "Race: $race"
            tvFullName.text = "FullName: $fullName"
            tvPlaceOfBirth.text = "PlaceOfBirth: $placeOfBirth"
            tvPublisher.text = "Publisher: $publisher"
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() = SuperHeroItemFragment()
    }
}