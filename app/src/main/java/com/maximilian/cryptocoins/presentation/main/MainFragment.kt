package com.maximilian.cryptocoins.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.maximilian.cryptocoins.adapters.CoinsAdapter
import com.maximilian.cryptocoins.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding ?= null
    private val binding: FragmentMainBinding
        get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    private val adapter = CoinsAdapter {coin ->
        findNavController().navigate(MainFragmentDirections.showDetailed(coin))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCoins.layoutManager = LinearLayoutManager(context)

        observeViewModel()
        binding.rvCoins.adapter = adapter

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filterList(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })
        viewModel.fetchCoinsListFromDb()
    }

    private fun observeViewModel() {
        viewModel.coinsLiveData.observe(viewLifecycleOwner) {
            Log.d("MainFragment", it.toString())
            adapter.submitList(it)
            adapter.submitOriginalList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}