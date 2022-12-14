package com.moonlightbutterfly.backbaseassignment.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moonlightbutterfly.backbaseassignment.data.dtos.CityDTO
import com.moonlightbutterfly.backbaseassignment.data.searchalgorithms.SearchAlgorithm
import com.moonlightbutterfly.core.data.CitiesDataSource
import com.moonlightbutterfly.core.models.City
import com.moonlightbutterfly.core.models.Coordinates

class CitiesDataSourceImpl(
    context: Context,
    private val searchAlgorithm: SearchAlgorithm,
) : CitiesDataSource {

    init {
        context.assets.open(CITIES_FILENAME).readBytes().decodeToString().let {
            val objectType = object : TypeToken<List<CityDTO>>() {}.type
            val entityList = Gson().fromJson<List<CityDTO>>(it, objectType)
            entityList.map { cityDTO ->
                City(cityDTO._id,
                    cityDTO.country,
                    cityDTO.name,
                    Coordinates(cityDTO.coord.lon, cityDTO.coord.lat))
            }
        }.also {
            searchAlgorithm.loadCollection(it) { city1, city2 ->
                val result = city1.cityName.compareTo(city2.cityName, true)
                if (result == 0) {
                    city1.countryCode.compareTo(city2.countryCode, true)
                } else result
            }
        }
    }

    override fun getCities(page: Int, pageSize: Int, query: String?): List<City> {
        if (query == null) {
            return searchAlgorithm.getCollection().getSubList(page, pageSize)
        }
        return searchAlgorithm.filterCollection(query).getSubList(page, pageSize)
    }

    private fun List<City>.getSubList(page: Int, pageSize: Int): List<City> {
        val firstIndex = (page - 1) * pageSize
        val lastIndex = pageSize * page
        return when {
            this.size - 1 < firstIndex -> emptyList()
            this.size - 1 < lastIndex -> this
            else -> this.subList(firstIndex, lastIndex)
        }
    }

    private companion object {
        private const val CITIES_FILENAME = "cities.json"
    }

}