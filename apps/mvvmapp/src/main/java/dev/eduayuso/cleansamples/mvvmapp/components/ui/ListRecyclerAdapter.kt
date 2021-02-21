package dev.eduayuso.cleansamples.mvvmapp.components.ui

import androidx.recyclerview.widget.RecyclerView
import dev.eduayuso.cleansamples.shared.domain.entities.IEntity

abstract class ListRecyclerAdapter<EntityType: IEntity, VH: CleanViewHolder>:

    RecyclerView.Adapter<VH>() {

    protected var dataList: MutableList<EntityType> = mutableListOf()

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