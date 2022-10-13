package com.moonlightbutterfly.backbaseassignment.ui.cities

import androidx.lifecycle.ViewModel
import com.moonlightbutterfly.core.models.City
import com.moonlightbutterfly.core.usecases.GetCitiesUseCase

class CitiesViewModel(getCitiesUseCase: GetCitiesUseCase) : ViewModel() {

    val cities: List<City> = getCitiesUseCase()
}