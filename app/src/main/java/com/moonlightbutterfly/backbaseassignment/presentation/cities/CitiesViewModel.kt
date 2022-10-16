package com.moonlightbutterfly.backbaseassignment.presentation.cities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.moonlightbutterfly.backbaseassignment.presentation.CitiesPagingSource
import com.moonlightbutterfly.core.models.City
import com.moonlightbutterfly.core.usecases.GetCitiesUseCase
import javax.inject.Inject

class CitiesViewModel @Inject constructor(getCitiesUseCase: GetCitiesUseCase) : ViewModel() {

    private var query: String? = null

    val flow = Pager(
        PagingConfig(PAGE_SIZE)
    ) {
        CitiesPagingSource(getCitiesUseCase, query, PAGE_SIZE)
    }.flow
        .cachedIn(viewModelScope)

    fun onSearchChanged(newText: String) {
        query = newText.ifEmpty { null }
    }

    private companion object {
        private const val PAGE_SIZE = 20
    }
}