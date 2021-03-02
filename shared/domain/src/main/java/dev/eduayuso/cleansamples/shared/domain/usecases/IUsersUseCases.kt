package dev.eduayuso.cleansamples.shared.domain.usecases

import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

interface IUsersUseCases: IUseCases {

    suspend fun getUserList(): List<UserEntity>

    suspend fun getUserDetail(id: String): UserEntity?

    suspend fun getPostsByUser(id: String): List<PostEntity>?
}