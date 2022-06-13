package com.example.wildberriesweekfive

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wildberriesweekfive.databinding.FragmentSuperHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class SuperHeroesListFragment : Fragment() {
    lateinit var binding: FragmentSuperHeroesListBinding
    lateinit var superHeroViewModel: SuperHeroViewModel
    var superHeroItems: List<SuperHeroJSON>? = null
    private val adapter = SuperHeroAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        superHeroViewModel = ViewModelProvider(requireActivity()).get(SuperHeroViewModel::class.java)
        binding = FragmentSuperHeroesListBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        readData()
        if (superHeroItems == null){
            superHeroViewModel.request()
        }
        else{
            adapter.getSuperHeroesData(superHeroItems!!)
            adapter.notifyDataSetChanged()
        }

    }



    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        superHeroViewModel.itemsSuperHeroes.observe(activity as LifecycleOwner, Observer {
            superHeroItems = it
            saveData(superHeroItems!!)
            adapter.getSuperHeroesData(superHeroItems!!)
            adapter.notifyDataSetChanged()
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.rcSuperHeroes.layoutManager = LinearLayoutManager(context)
        binding.rcSuperHeroes.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = SuperHeroesListFragment()
        const val SHARED_PREF = "SHARED_PREF"
    }


    private fun saveData(superHeroes: List<SuperHeroJSON>) {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = sharedPrefs.edit()
        val gson = Gson()

        val json = gson.toJson(superHeroes)

        editor.putString(SHARED_PREF, json)
        editor.commit()
    }



    fun readData() {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()
        val json = sharedPrefs.getString(SHARED_PREF, "")
        val type = object : TypeToken<List<SuperHeroJSON?>?>() {}.type
        superHeroItems = gson.fromJson<List<SuperHeroJSON>>(json, type)
    }
}