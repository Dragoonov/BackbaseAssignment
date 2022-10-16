package com.moonlightbutterfly.backbaseassignment.presentation.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.moonlightbutterfly.backbaseassignment.databinding.FragmentCitiesBinding
import com.moonlightbutterfly.backbaseassignment.presentation.MainActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class CitiesFragment : Fragment() {

    private val viewModel by viewModels<CitiesViewModel> {
        (requireActivity() as MainActivity).component.viewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentCitiesBinding.inflate(inflater)
        val cityAdapter = CityAdapter(CityComparator)
        binding.cities.apply {
            adapter = cityAdapter
            layoutManager = LinearLayoutManager(context)
        }
        binding.editText.doOnTextChanged { text, _, _, _ ->
            viewModel.onSearchChanged(text.toString())
            cityAdapter.refresh()
        }
        lifecycleScope.launch {
            viewModel.citiesFlow.collectLatest { pagingData ->
                cityAdapter.submitData(pagingData)
            }
        }
        return binding.root
    }

}