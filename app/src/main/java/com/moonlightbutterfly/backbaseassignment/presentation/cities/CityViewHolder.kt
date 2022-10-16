package com.moonlightbutterfly.backbaseassignment.presentation.cities

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.moonlightbutterfly.backbaseassignment.databinding.CityCardBinding
import com.moonlightbutterfly.core.models.City

class CityViewHolder(private val binding: CityCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(city: City?) {
        binding.apply {
            city?.let {
                val action = CitiesFragmentDirections.actionCitiesFragmentToCityFragment(it)
                root.setOnClickListener { view ->
                    view.findNavController().navigate(action)
                }
            }
            title.text = "${city?.cityName}, ${city?.countryCode}"
            subtitle.text = "Latitude: ${city?.coordinates?.latitude}, Longitude: ${city?.coordinates?.longitude}"
        }
    }
}