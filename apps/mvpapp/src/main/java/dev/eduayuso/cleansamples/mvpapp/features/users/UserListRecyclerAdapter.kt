package dev.eduayuso.cleansamples.mvpapp.features.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.bindImageUrl
import dev.eduayuso.cleansamples.mvpapp.components.inflate
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvpapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

class UserListRecyclerAdapter:

    ListRecyclerAdapter<
            UserEntity,
            UserListRecyclerAdapter.ListViewHolder
            >() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        
        val view = parent.inflate(R.layout.item_user)
        return ListViewHolder(view)
    }

    inner class ListViewHolder(view: View): CleanViewHolder(view) {

        override fun onBind(position: Int) {

            val user = items[position]

            /**
             * User name
             */
            itemView.findViewById<TextView>(R.id.nameTextView).apply {
                text = "${user.firstName} ${user.lastName}"
            }

            /**
             * User email
             */
            itemView.findViewById<TextView>(R.id.emailTextView).apply {
                text = "${user.email}"
            }

            /**
             * User picture
             */
            itemView.findViewById<ImageView>(R.id.userImageView).apply {
                bindImageUrl(user.picture)
            }
        }
    }
}