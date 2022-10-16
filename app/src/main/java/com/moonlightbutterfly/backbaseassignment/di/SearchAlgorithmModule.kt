package com.moonlightbutterfly.backbaseassignment.di

import com.moonlightbutterfly.backbaseassignment.data.searchalgorithms.DummySearchAlgorithm
import com.moonlightbutterfly.backbaseassignment.data.searchalgorithms.BinarySearchAlgorithm
import com.moonlightbutterfly.backbaseassignment.data.searchalgorithms.SearchAlgorithm
import dagger.Binds
import dagger.Module
import javax.inject.Qualifier

@Module
interface SearchAlgorithmModule {

    @Binds
    @DummyAlgorithm
    fun bindDummyAlgorithm(algorithm: DummySearchAlgorithm): SearchAlgorithm

    @Binds
    @FastAlgorithm
    fun bindFastAlgorithm(algorithm: BinarySearchAlgorithm): SearchAlgorithm

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DummyAlgorithm

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FastAlgorithm