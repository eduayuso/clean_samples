package dev.eduayuso.cleansamples.mvvmapp.features.tags

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvvmapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.mvvmapp.databinding.ItemTagBinding
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity

class TagListRecyclerAdapter(

private val listener: OnTagClickListener

): ListRecyclerAdapter<
    TagEntity,
    TagListRecyclerAdapter.ListViewHolder
    >() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {

        val listItemBinding = ItemTagBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(listItemBinding)
    }

    inner class ListViewHolder(private val boundItem: ItemTagBinding):

        CleanViewHolder(boundItem.root) {

        override fun onBind(position: Int) {

            boundItem.tag = dataList[position]
            boundItem.listener = listener
            boundItem.executePendingBindings()
        }
    }
}