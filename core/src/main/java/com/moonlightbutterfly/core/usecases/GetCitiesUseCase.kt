package com.moonlightbutterfly.core.usecases

import com.moonlightbutterfly.core.data.CitiesRepository

class GetCitiesUseCase(private val citiesRepository: CitiesRepository) {
    operator fun invoke(page: Int, pageSize: Int, query: String?) =
        citiesRepository.getCities(page, pageSize, query)
}