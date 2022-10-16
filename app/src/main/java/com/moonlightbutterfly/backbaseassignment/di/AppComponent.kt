package com.moonlightbutterfly.backbaseassignment.di

import android.content.Context
import com.moonlightbutterfly.backbaseassignment.presentation.ViewModelFactory
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, SearchAlgorithmModule::class, UseCasesModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

    fun viewModelFactory(): ViewModelFactory
}