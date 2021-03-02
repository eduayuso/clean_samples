package dev.eduayuso.cleansamples.shared.impl.di

import dev.eduayuso.cleansamples.shared.impl.services.UsersService
import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.services.IPostsService
import dev.eduayuso.cleansamples.shared.data.services.ITagsService
import dev.eduayuso.cleansamples.shared.data.services.IUsersService
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.ITagsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.impl.DataManager
import dev.eduayuso.cleansamples.shared.impl.interactors.PostsInteractor
import dev.eduayuso.cleansamples.shared.impl.interactors.TagsInteractor
import dev.eduayuso.cleansamples.shared.impl.interactors.UsersInteractor
import dev.eduayuso.cleansamples.shared.impl.services.PostsService
import dev.eduayuso.cleansamples.shared.impl.services.TagsService
import dev.eduayuso.cleansamples.shared.impl.source.cache.PostsCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.cache.TagsCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.cache.UsersCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.PostsRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.TagsRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.UsersRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl.ApiClient
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl.HttpApiClient
import org.koin.dsl.module

object DepsInjection: IDepsInjection() {

    override val interactorsModule = module {

        single { provideUsersUseCases() }
        single { providePostsUseCases() }
        single { provideTagsUseCases() }
    }

    fun provideUsersUseCases(): IUsersUseCases = UsersInteractor()
    fun providePostsUseCases(): IPostsUseCases = PostsInteractor()
    fun provideTagsUseCases(): ITagsUseCases = TagsInteractor()

    override val servicesModule = module {

        single { provideUsersService() }
        single { providePostsService() }
        single { provideTagsService() }
    }

    fun provideUsersService(): IUsersService = UsersService()
    fun providePostsService(): IPostsService = PostsService()
    fun provideTagsService(): ITagsService = TagsService()

    override val repositoryModule = module {

        /**
         * Users repositories
         */
        single { UsersCacheRepository() }
        single { UsersRemoteRepository() }
        // single { UsersDbRepository(get()) }
        // single { UsersPrefsRepository(get()) }

        /**
         * Posts repositories
         */
        single { PostsCacheRepository() }
        single { PostsRemoteRepository() }

        /**
         * Tags repositories
         */
        single { TagsCacheRepository() }
        single { TagsRemoteRepository() }
    }

    override val remoteApiClient = module {

        single { provideApiClient() }
    }

    fun provideApiClient() = ApiClient(
        DataConstants.Apis.DummyApi.url,
        HttpApiClient.build()
    )

    override val dataModule = module {

        single { provideDataManager() }
    }

    fun provideDataManager(): IDataManager = DataManager()
}