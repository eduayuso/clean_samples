package dev.eduayuso.cleansamples.mvvmapp.features.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvvmapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.mvvmapp.databinding.ItemCommentBinding
import dev.eduayuso.cleansamples.shared.domain.entities.CommentEntity

class CommentsListRecyclerAdapter: ListRecyclerAdapter<
        CommentEntity,
        CommentsListRecyclerAdapter.ListViewHolder
        >() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {

        val listItemBinding = ItemCommentBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(listItemBinding)
    }

    inner class ListViewHolder(private val boundItem: ItemCommentBinding):

        CleanViewHolder(boundItem.root) {

        override fun onBind(position: Int) {

            boundItem.comment = dataList[position]
            boundItem.executePendingBindings()
        }
    }
}