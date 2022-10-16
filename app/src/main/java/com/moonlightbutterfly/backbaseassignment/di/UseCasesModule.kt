package com.moonlightbutterfly.backbaseassignment.di

import com.moonlightbutterfly.core.data.CitiesRepository
import com.moonlightbutterfly.core.usecases.GetCitiesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideGetCitiesUseCase(
        citiesRepository: CitiesRepository,
    ): GetCitiesUseCase {
        return GetCitiesUseCase(citiesRepository)
    }

}