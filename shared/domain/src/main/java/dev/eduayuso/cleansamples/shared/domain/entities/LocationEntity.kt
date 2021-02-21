package dev.eduayuso.cleansamples.shared.domain.entities

import kotlinx.serialization.Serializable

@Serializable
class LocationEntity(

    val state: String? = null,
    val street: String? = null,
    val city: String? = null,
    val timezone: String? = null,
    val country: String? = null
)