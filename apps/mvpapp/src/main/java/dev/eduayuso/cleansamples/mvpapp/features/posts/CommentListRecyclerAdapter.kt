package dev.eduayuso.cleansamples.mvpapp.features.posts

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.bindAvatarUrl
import dev.eduayuso.cleansamples.mvpapp.components.inflate
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvpapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.domain.entities.CommentEntity

class CommentListRecyclerAdapter:

    ListRecyclerAdapter<CommentEntity, CommentListRecyclerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {

        val view = parent.inflate(R.layout.item_comment)
        return ListViewHolder(view)
    }

    inner class ListViewHolder(view: View) : CleanViewHolder(view) {

        override fun onBind(position: Int) {

            val comment = items[position]

            itemView.findViewById<TextView>(R.id.publishDateTextView).apply {
                text = "${comment.publishDate}"
            }

            itemView.findViewById<TextView>(R.id.commentTextView).apply {
                text = "${comment.message}"
            }

            itemView.findViewById<ImageView>(R.id.userImageView).apply {
                bindAvatarUrl(comment.owner!!.picture)
            }
        }
    }
}