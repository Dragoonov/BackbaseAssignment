package com.moonlightbutterfly.backbaseassignment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moonlightbutterfly.backbaseassignment.presentation.cities.CitiesViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor (
    private val citiesViewModelProvider: Provider<CitiesViewModel>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.let {
            when {
                it.isAssignableFrom(CitiesViewModel::class.java) -> citiesViewModelProvider.get()
                else -> throw IllegalArgumentException("Unknown ViewModel class")
            } as T
        }
    }
}
