package com.moonlightbutterfly.core.usecases

import com.moonlightbutterfly.core.data.CitiesRepository

class GetCitiesUseCase(private val citiesRepository: CitiesRepository) {
    operator fun invoke() = citiesRepository.getCities()
}