package com.moonlightbutterfly.backbaseassignment.presentation

import com.moonlightbutterfly.core.models.City
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.moonlightbutterfly.core.usecases.GetCitiesUseCase

class CitiesPagingSource(
    private val getCitiesUseCase: GetCitiesUseCase,
    private val query: String?,
    private val pageSize: Int
) : PagingSource<Int, City>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, City> {
        return try {
            val page = params.key ?: 1
            val response = getCitiesUseCase(page, pageSize, query)
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = if (response.isEmpty()) null else page+1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, City>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}