package dev.eduayuso.cleansamples.mvpapp.features.tags

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.inflate
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvpapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity

class TagMiniListRecyclerAdapter(

    private val listener: OnTagClickListener

): ListRecyclerAdapter<
        TagEntity,
        TagMiniListRecyclerAdapter.ListViewHolder
    >() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {

        val view = parent.inflate(R.layout.item_tag_mini)
        return ListViewHolder(view)
    }

    inner class ListViewHolder(view: View) : CleanViewHolder(view) {

        override fun onBind(position: Int) {

            val tag = items[position]

            itemView.findViewById<TextView>(R.id.tagButton).apply {
                text = "${tag.id}"
                setOnClickListener {
                    listener.onTagClick(tag.id ?: "")
                }
            }
        }
    }
}