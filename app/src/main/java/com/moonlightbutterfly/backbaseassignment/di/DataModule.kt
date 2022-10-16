package com.moonlightbutterfly.backbaseassignment.di

import android.content.Context
import com.moonlightbutterfly.backbaseassignment.data.CitiesDataSourceImpl
import com.moonlightbutterfly.backbaseassignment.data.searchalgorithms.SearchAlgorithm
import com.moonlightbutterfly.core.data.CitiesDataSource
import com.moonlightbutterfly.core.data.CitiesRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCitiesDataSource(
        context: Context,
        @FastAlgorithm algorithm: SearchAlgorithm,
    ): CitiesDataSource {
        return CitiesDataSourceImpl(context, algorithm)
    }

    @Provides
    fun provideCitiesRepository(citiesDataSource: CitiesDataSource): CitiesRepository {
        return CitiesRepository(citiesDataSource)
    }
}