import android.view.LayoutInflater
import android.view.ViewGroup
import dev.eduayuso.cleansamples.mvvmapp.components.ui.CleanViewHolder
import dev.eduayuso.cleansamples.mvvmapp.components.ui.ListRecyclerAdapter
import dev.eduayuso.cleansamples.mvvmapp.databinding.ItemUserBinding
import dev.eduayuso.cleansamples.mvvmapp.features.users.OnUserClickListener
import dev.eduayuso.cleansamples.shared.domain.entities.UserEntity
import dev.eduayuso.cleansamples.shared.presentation.mvvm.features.users.UserListViewModel

class UserListRecyclerAdapter(

    private val listener: OnUserClickListener

): ListRecyclerAdapter<
        UserEntity,
        UserListRecyclerAdapter.ListViewHolder
    >() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        
        val listItemBinding = ItemUserBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(listItemBinding)
    }

    inner class ListViewHolder(private val boundItem: ItemUserBinding):

        CleanViewHolder(boundItem.root) {

        override fun onBind(position: Int) {

            boundItem.user = dataList[position]
            boundItem.listener = listener
            boundItem.executePendingBindings()
        }
    }
}