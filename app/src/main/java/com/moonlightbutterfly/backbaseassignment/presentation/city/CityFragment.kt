package com.moonlightbutterfly.backbaseassignment.presentation.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.moonlightbutterfly.backbaseassignment.R
import com.moonlightbutterfly.backbaseassignment.databinding.FragmentCityBinding
import com.moonlightbutterfly.core.models.City


class CityFragment : Fragment() {

    private val args: CityFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCityBinding.inflate(inflater)
        binding.cityInfo.text = getString(R.string.map_info, args.city)
        return binding.root
    }

}