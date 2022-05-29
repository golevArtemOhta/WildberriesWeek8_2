package com.example.wildberriesweekfive

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wildberriesweekfive.databinding.FragmentSuperHeroesListBinding


class SuperHeroesListFragment : Fragment() {
    lateinit var binding: FragmentSuperHeroesListBinding
    lateinit var superHeroViewModel: SuperHeroViewModel
    lateinit var superHeroItems: List<SuperHeroJSON>
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

            superHeroViewModel.request()


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        superHeroViewModel.itemsSuperHeroes.observe(activity as LifecycleOwner, Observer {
            superHeroItems = it
            adapter.getSuperHeroesData(superHeroItems)
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
    }
}