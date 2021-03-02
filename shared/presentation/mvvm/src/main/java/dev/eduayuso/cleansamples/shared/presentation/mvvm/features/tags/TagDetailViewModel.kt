package dev.eduayuso.cleansamples.shared.presentation.mvvm.features.tags

import dev.eduayuso.cleansamples.shared.domain.usecases.IPostsUseCases
import dev.eduayuso.cleansamples.shared.domain.usecases.ITagsUseCases
import dev.eduayuso.cleansamples.shared.presentation.mvvm.CleanViewModel
import org.koin.java.KoinJavaComponent.inject

class TagDetailViewModel: CleanViewModel() {

    override val interactor by inject(ITagsUseCases::class.java)
}