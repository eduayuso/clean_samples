import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvvmapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.mvvmapp.databinding.ItemPostBinding
import dev.eduayuso.cleansamples.mvvmapp.databinding.ItemUserBinding
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity

class PostListRecyclerAdapter:

    ListRecyclerAdapter<
        PostEntity,
        PostListRecyclerAdapter.ListViewHolder
        >() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {

        val listItemBinding = ItemPostBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(listItemBinding)
    }

    inner class ListViewHolder(private val boundItem: ItemPostBinding):

            CleanViewHolder(boundItem.root) {

        override fun onBind(position: Int) {

            boundItem.post = dataList[position]
            boundItem.executePendingBindings()
        }
    }
}