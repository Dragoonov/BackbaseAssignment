package com.moonlightbutterfly.backbaseassignment.presentation.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.moonlightbutterfly.backbaseassignment.databinding.CityCardBinding
import com.moonlightbutterfly.core.models.City

class CityAdapter(diffCallback: DiffUtil.ItemCallback<City>) :
    PagingDataAdapter<City, CityViewHolder>(diffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityViewHolder {
        val binding: CityCardBinding =
            CityCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}