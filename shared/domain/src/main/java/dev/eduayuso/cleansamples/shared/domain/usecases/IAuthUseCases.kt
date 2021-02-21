package dev.eduayuso.cleansamples.shared.domain.usecases

import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

interface IAuthUseCases: IUseCases {

    suspend fun login(email: String, password: String): UserEntity?

    suspend fun signUp(email: String, password: String, name: String): UserEntity?

    suspend fun resetPass(email: String): Boolean
}