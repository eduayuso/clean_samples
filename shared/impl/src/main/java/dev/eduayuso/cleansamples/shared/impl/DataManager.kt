package dev.eduayuso.cleansamples.shared.impl

import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.services.IPostsService
import dev.eduayuso.cleansamples.shared.data.services.IUsersService
import org.koin.java.KoinJavaComponent.inject

class DataManager: IDataManager {

    override val users by inject(IUsersService::class.java)
    override val posts by inject(IPostsService::class.java)
}