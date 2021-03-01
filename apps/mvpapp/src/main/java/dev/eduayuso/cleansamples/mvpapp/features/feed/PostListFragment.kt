package dev.eduayuso.cleansamples.mvpapp.features.feed

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanFragment
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.feed.IPostListEvents
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.feed.PostListPresenter
import org.koin.java.KoinJavaComponent.inject

class PostListFragment: CleanFragment<IPostListEvents>(), IPostListEvents {

    override val presenter by inject(PostListPresenter::class.java)
    override val layoutResourceId = R.layout.fragment_post_list

    private val progressBar by lazy     { view?.findViewById<ProgressBar>(R.id.postListProgressBar) }
    private val recyclerView by lazy    { view?.findViewById<RecyclerView>(R.id.postListRecyclerView) }
    private var recyclerAdapter: PostListRecyclerAdapter? = null

    override fun onResume() {

        super.onResume()
        this.presenter.fetchPosts()
    }

    override fun showLoading() {

        progressBar?.visibility = View.VISIBLE
    }

    override fun hideLoading() {

        progressBar?.visibility = View.GONE
    }

    override fun onPostListFetched(posts: List<PostEntity>) {

        recyclerAdapter?.addItems(posts)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        recyclerView?.let {
            it.layoutManager = GridLayoutManager(activity, 1)
            it.setHasFixedSize(true)
            it.adapter = PostListRecyclerAdapter()
        }
        recyclerAdapter = recyclerView?.adapter as PostListRecyclerAdapter
    }
}