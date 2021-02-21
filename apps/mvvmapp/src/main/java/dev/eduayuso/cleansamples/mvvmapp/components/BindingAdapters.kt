package dev.eduayuso.cleansamples.mvvmapp.components

import PostListRecyclerAdapter
import UserListRecyclerAdapter
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

@BindingAdapter(value = ["setImageUrl"])
fun ImageView.bindImageUrl(url: String?) {

    if (url != null && url.isNotBlank()) {
        Picasso.get()
            .load(url)
            .into(this)
    }
}

@BindingAdapter("userListAdapter")
fun bindUserListAdapter(recyclerView: RecyclerView, userList: List<UserEntity>) {

    val adapter = recyclerView.adapter as UserListRecyclerAdapter?
    adapter?.addItems(userList)
}

@BindingAdapter("postListAdapter")
fun bindPostListAdapter(recyclerView: RecyclerView, userList: List<PostEntity>) {

    val adapter = recyclerView.adapter as PostListRecyclerAdapter?
    adapter?.addItems(userList)
}