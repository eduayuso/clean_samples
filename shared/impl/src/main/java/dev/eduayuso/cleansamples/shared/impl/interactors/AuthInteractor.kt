package dev.eduayuso.cleansamples.shared.impl.interactors

import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.IInteractor
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.domain.usecases.IAuthUseCases

class AuthInteractor(

    override val data: IDataManager

): IAuthUseCases, IInteractor {

    override suspend fun login(email: String, password: String): UserEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(email: String, password: String, name: String): UserEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun resetPass(email: String): Boolean {
        TODO("Not yet implemented")
    }
}