package com.moonlightbutterfly.backbaseassignment.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moonlightbutterfly.backbaseassignment.data.dtos.CityDTO
import com.moonlightbutterfly.core.data.CitiesDataSource
import com.moonlightbutterfly.core.models.City
import com.moonlightbutterfly.core.models.Coordinates

class CitiesDataSourceImpl(context: Context): CitiesDataSource  {

    private val citiesJson = context.assets.open(CITIES_FILENAME).readBytes().decodeToString()

    override fun getCities(): List<City> {
        val objectType = object : TypeToken<List<CityDTO>>() {}.type
        val entityList = Gson().fromJson<List<CityDTO>>(citiesJson, objectType)
        return entityList.map {
            City(it._id, it.country, it.name, Coordinates(it.coord.lon, it.coord.lat))
        }
    }

    private companion object {
        private const val CITIES_FILENAME = "cities.json"
    }

}