package dev.eduayuso.cleansamples.mvpapp.features.posts

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.bindImageUrl
import dev.eduayuso.cleansamples.mvpapp.components.inflate
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvpapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity

class PostMiniListRecyclerAdapter(

    private val listener: OnPostClickListener

): ListRecyclerAdapter<
        PostEntity,
        PostMiniListRecyclerAdapter.ListViewHolder
    >() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {

        val view = parent.inflate(R.layout.item_post_mini)
        return ListViewHolder(view)
    }

    inner class ListViewHolder(view: View) : CleanViewHolder(view) {

        override fun onBind(position: Int) {

            val post = items[position]

            itemView.findViewById<ImageView>(R.id.postImageView).apply {
                bindImageUrl(post.image)
            }

            itemView.findViewById<TextView>(R.id.contentTextView).apply {
                text = post.text
            }

            itemView.findViewById<TextView>(R.id.dateTextView).apply {
                text = post.publishDate
            }

            itemView.setOnClickListener {
                listener.onPostClick(post.id ?: "")
            }
        }
    }
}