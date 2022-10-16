package com.moonlightbutterfly.backbaseassignment.presentation.cities

import androidx.recyclerview.widget.DiffUtil
import com.moonlightbutterfly.core.models.City

object CityComparator : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }
}