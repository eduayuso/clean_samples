package dev.eduayuso.cleansamples.mvpapp.components.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class CleanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)
}