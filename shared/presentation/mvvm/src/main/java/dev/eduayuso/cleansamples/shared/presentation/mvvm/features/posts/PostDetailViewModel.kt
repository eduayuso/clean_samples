package dev.eduayuso.cleansamples.shared.presentation.mvvm.features.posts

import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel
import org.koin.java.KoinJavaComponent.inject

class PostDetailViewModel: CleanViewModel() {

    override val interactor by inject(IPostsUseCases::class.java)
}