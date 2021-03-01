package dev.eduayuso.cleansamples.mvpapp.features.feed

import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.bindImageUrl
import dev.eduayuso.cleansamples.mvpapp.components.inflate
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvpapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity

class PostListRecyclerAdapter:

    ListRecyclerAdapter<PostEntity, PostListRecyclerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostListRecyclerAdapter.ListViewHolder {

        val view = parent.inflate(R.layout.item_post)
        return ListViewHolder(view)
    }

    inner class ListViewHolder(itemView: View): CleanViewHolder(itemView) {

        override fun onBind(position: Int) {

            val post = items[position]

            /**
             * Author name
             */
            itemView.findViewById<TextView>(R.id.authorName).apply {
                text = "${post.owner?.firstName} ${post.owner?.lastName}"
            }

            /**
             * Author picture
             */
            itemView.findViewById<ImageView>(R.id.authorImageView).apply {
                bindImageUrl(post.owner?.picture)
            }

            /**
             * Publish date
             */
            itemView.findViewById<TextView>(R.id.publishDate).apply {
                text = "${post.publishDate}"
            }

            /**
             * Post image
             */
            itemView.findViewById<ImageView>(R.id.postImageView).apply {
                bindImageUrl(post.image)
            }

            /**
             * Publish date
             */
            itemView.findViewById<TextView>(R.id.postText).apply {
                text = "${post.text}"
            }
        }
    }
}