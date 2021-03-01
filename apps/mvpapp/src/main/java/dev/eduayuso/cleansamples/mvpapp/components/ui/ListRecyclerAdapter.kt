package dev.eduayuso.cleansamples.mvpapp.components.ui

import androidx.recyclerview.widget.RecyclerView
import dev.eduayuso.cleansamples.shared.domain.entities.IEntity

abstract class ListRecyclerAdapter<EntityType: IEntity, VH: CleanViewHolder>:

    RecyclerView.Adapter<VH>() {

    private var dataList: MutableList<EntityType> = mutableListOf()
    val items: List<EntityType> get() = dataList

    override fun onBindViewHolder(viewHolder: VH, i: Int) {
        viewHolder.onBind(i)
    }

    override fun getItemCount(): Int {

        return dataList.size
    }

    fun addItems(data: List<EntityType>) {

        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }
}