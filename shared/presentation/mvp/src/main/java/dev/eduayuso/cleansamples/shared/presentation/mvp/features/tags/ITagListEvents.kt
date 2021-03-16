package dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags

import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.presentation.mvp.IViewEvents

interface ITagListEvents: IViewEvents {

    fun showLoading()
    fun hideLoading()
    fun onTagListFetched(tags: List<TagEntity>)
}