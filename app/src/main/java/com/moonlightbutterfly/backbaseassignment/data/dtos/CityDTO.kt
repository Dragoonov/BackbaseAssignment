package com.moonlightbutterfly.backbaseassignment.data.dtos

/**
 * A data transfer object that is used to get data from data source.
 */
data class CityDTO(
    val _id: Long,
    val country: String,
    val name: String,
    val coord: CoordinatesDTO,
)