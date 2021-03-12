package dev.eduayuso.cleansamples.mvvmapp.components

import PostListRecyclerAdapter
import PostMiniListRecyclerAdapter
import UserListRecyclerAdapter
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import dev.eduayuso.cleansamples.mvvmapp.features.posts.CommentsListRecyclerAdapter
import dev.eduayuso.cleansamples.mvvmapp.features.tags.TagListRecyclerAdapter
import dev.eduayuso.cleansamples.mvvmapp.features.tags.TagMiniListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.domain.entities.CommentEntity
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@BindingAdapter("setImageUrl")
fun ImageView.bindImageUrl(url: String?) {

    if (url != null && url.isNotBlank()) {
        Picasso.get()
            .load(url)
            .into(this)
    }
}

@BindingAdapter("setAvatarUrl")
fun ImageView.bindAvatarUrl(url: String?) {

    if (url != null && url.isNotBlank()) {
        Picasso.get()
                .load(url)
                .transform(CropCircleTransformation())
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

@BindingAdapter("postMiniListAdapter")
fun bindPostMiniAdapter(recyclerView: RecyclerView, userList: List<PostEntity>) {

    val adapter = recyclerView.adapter as PostMiniListRecyclerAdapter?
    adapter?.addItems(userList)
}

@BindingAdapter("tagListAdapter")
fun bindTagListAdapter(recyclerView: RecyclerView, tags: List<TagEntity>) {

    val adapter = recyclerView.adapter as TagListRecyclerAdapter?
    adapter?.addItems(tags)
}

@BindingAdapter("tagMiniListAdapter")
fun bindTagMiniListAdapter(recyclerView: RecyclerView, tags: List<TagEntity>) {

    val adapter = recyclerView.adapter as TagMiniListRecyclerAdapter?
    adapter?.addItems(tags)
}

@BindingAdapter("commentsListAdapter")
fun bindCommentsAdapter(recyclerView: RecyclerView, userList: List<CommentEntity>) {

    val adapter = recyclerView.adapter as CommentsListRecyclerAdapter?
    adapter?.addItems(userList)
}

@BindingAdapter("textDate")
fun TextView.bindDate(date: String?) {

    if (date != null && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        val DATE_UTC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        var formatter = DateTimeFormatter.ofPattern(DATE_UTC_PATTERN)
        this.text = LocalDate.parse(date, formatter).toString()
    } else {
        this.text = date
    }
}