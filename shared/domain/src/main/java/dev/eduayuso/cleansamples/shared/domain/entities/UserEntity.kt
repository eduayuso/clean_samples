package dev.eduayuso.cleansamples.shared.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(

    var id: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var picture: String? = null,
    var location: LocationEntity? = null,
    var gender: String? = null,
    var dateOfBirth: String? = null,

): IEntity

@Serializable
data class UserListResponse(

    val data: List<UserEntity>? = null,
    val total: Int? = null,
    val page: Int? = null
)