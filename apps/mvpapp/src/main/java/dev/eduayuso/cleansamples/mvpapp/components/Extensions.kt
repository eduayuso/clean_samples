package dev.eduayuso.cleansamples.mvpapp.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(@LayoutRes resource: Int): View {

    return LayoutInflater.from(context).inflate(resource, this, false)
}

fun ImageView.bindImageUrl(url: String?) {

    if (url != null && url.isNotBlank()) {
        Picasso.get()
                .load(url)
                .into(this)
    }
}