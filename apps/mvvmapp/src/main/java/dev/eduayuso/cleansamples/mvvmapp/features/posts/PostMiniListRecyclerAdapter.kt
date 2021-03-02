import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvvmapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.mvvmapp.databinding.ItemPostBinding
import dev.eduayuso.cleansamples.mvvmapp.databinding.ItemPostMiniBinding
import dev.eduayuso.cleansamples.mvvmapp.databinding.ItemUserBinding
import dev.eduayuso.cleansamples.mvvmapp.features.posts.OnPostClickListener
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.users.UserDetailViewModel

class PostMiniListRecyclerAdapter(

    private val listener: OnPostClickListener
):

    ListRecyclerAdapter<
        PostEntity,
        PostMiniListRecyclerAdapter.ListViewHolder
        >() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {

        val listItemBinding = ItemPostMiniBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(listItemBinding)
    }

    inner class ListViewHolder(private val boundItem: ItemPostMiniBinding):

            CleanViewHolder(boundItem.root) {

        override fun onBind(position: Int) {

            boundItem.post = dataList[position]
            boundItem.listener = listener
            boundItem.executePendingBindings()
        }
    }
}