package dev.eduayuso.cleansamples.shared.data

import dev.eduayuso.cleansamples.shared.data.services.IMessagesService
import dev.eduayuso.cleansamples.shared.data.services.IPostsService
import dev.eduayuso.cleansamples.shared.data.services.IUsersService

interface IDataManager {

    val users: IUsersService
    val posts: IPostsService
    //val messages: IMessagesService
}