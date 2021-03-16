package dev.eduayuso.cleansamples.mvpapp.features.tags

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.bindAvatarUrl
import dev.eduayuso.cleansamples.mvpapp.components.bindImageUrl
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanActivity
import dev.eduayuso.cleansamples.mvpapp.features.posts.*
import dev.eduayuso.cleansamples.shared.domain.entities.CommentEntity
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts.IPostDetailEvents
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts.PostDetailPresenter
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags.ITagDetailEvents
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags.TagDetailPresenter
import org.koin.java.KoinJavaComponent.inject

class TagDetailActivity:

    CleanActivity<ITagDetailEvents>(),
    ITagDetailEvents,
    OnPostClickListener {

    override val presenter by inject(TagDetailPresenter::class.java)
    override val layoutResourceId = R.layout.activity_tag_detail

    private val progressBar by lazy { findViewById<ProgressBar>(R.id.progressBar) }
    private val postRecyclerView by lazy { findViewById<RecyclerView>(R.id.postListRecyclerView) }
    private var postRecyclerAdapter: PostListRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.configRecyclerView()

        if (intent.extras != null) {
            intent.extras?.getString(DataConstants.ViewArguments.tagId).let {
                tagId ->
                presenter.fetchPostsByTag(tagId ?: "")
                supportActionBar?.title = "Posts tagged '$tagId'"
            }
        }
    }

    private fun configRecyclerView() {

        postRecyclerView?.let {
            it.layoutManager = GridLayoutManager(this, 1)
            it.setHasFixedSize(true)
            postRecyclerAdapter = PostListRecyclerAdapter(this)
            it.adapter = postRecyclerAdapter
        }
    }

    override fun showLoading() {

        progressBar?.visibility = View.VISIBLE
    }

    override fun hideLoading() {

        progressBar?.visibility = View.GONE
    }

    override fun onPostsFetched(posts: List<PostEntity>) {

        progressBar?.visibility = View.GONE
        postRecyclerView?.visibility = View.VISIBLE
        postRecyclerAdapter?.addItems(posts)
    }

    override fun onError(message: String) {

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onPostClick(id: String) {

        val intent = Intent(this, PostDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.postId, id)
        }
        startActivity(intent)
    }
}