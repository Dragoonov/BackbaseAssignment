package com.moonlightbutterfly.backbaseassignment.data.dtos

data class CityDTO(
    val _id: Long,
    val country: String,
    val name: String,
    val coord: CoordinatesDTO
)