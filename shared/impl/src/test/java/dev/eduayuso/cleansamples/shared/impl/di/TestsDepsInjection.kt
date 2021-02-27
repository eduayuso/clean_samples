package dev.eduayuso.cleansamples.shared.impl.di

import dev.eduayuso.cleansamples.shared.impl.services.UsersService
import dev.eduayuso.cleansamples.shared.data.IDataManager
import dev.eduayuso.cleansamples.shared.data.services.IPostsService
import dev.eduayuso.cleansamples.shared.data.services.IUsersService
import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.IUsersUseCases
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.impl.DataManager
import dev.eduayuso.cleansamples.shared.impl.interactors.PostsInteractor
import dev.eduayuso.cleansamples.shared.impl.interactors.UsersInteractor
import dev.eduayuso.cleansamples.shared.impl.services.PostsService
import dev.eduayuso.cleansamples.shared.impl.source.cache.UsersCacheRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.MessagesRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.PostsRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.UsersRemoteRepository
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.HttpMockApiClient
import dev.eduayuso.cleansamples.shared.impl.source.remote.ktor.impl.ApiClient
import dev.eduayuso.cleansamples.shared.presentation.features.users.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object TestsDepsInjection: IDepsInjection() {

    override val viewModelModule = module {

     /*   viewModel { AuthViewModel() }
        viewModel { HomeViewModel() }*/
        viewModel { UserListViewModel() }
      /*  viewModel { UserDetailViewModel() }
        viewModel { PostListViewModel() }*/
    }

    override val interactorsModule = module {

       //single { AuthInteractor(get()) }
        single { provideUsersUseCases() }
       /* single { providePostsUseCases() }
        single { MessagesInteractor(get()) }*/
    }

    private fun provideUsersUseCases(): IUsersUseCases = UsersInteractor()

    private fun providePostsUseCases(): IPostsUseCases = PostsInteractor()

    override val servicesModule = module {

        single { provideUsersService() }
        /*single { providePostsService() }
        single { MessagesService(get(), get()) }*/
    }

    private fun provideUsersService(): IUsersService = UsersService()
    private fun providePostsService(): IPostsService = PostsService()

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
        //single { PostsCacheRepository() }
        single { PostsRemoteRepository() }

        /**
         * Messages repositories
         */
        //single { MessagesCacheRepository() }
        single { MessagesRemoteRepository(get()) }
    }

    override val remoteApiClient = module {

        single { provideMockApiClient() }
    }

    private fun provideMockApiClient() = ApiClient(
        DataConstants.Apis.DummyApi.url,
        HttpMockApiClient.build()
    )

    override val dataModule = module {

        single { provideDataManager() }
    }

    fun provideDataManager(): IDataManager = DataManager()
}