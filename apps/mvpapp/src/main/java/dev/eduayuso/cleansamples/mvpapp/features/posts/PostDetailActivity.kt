package dev.eduayuso.cleansamples.mvpapp.features.posts

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
import dev.eduayuso.cleansamples.mvpapp.features.tags.OnTagClickListener
import dev.eduayuso.cleansamples.mvpapp.features.tags.TagDetailActivity
import dev.eduayuso.cleansamples.mvpapp.features.tags.TagMiniListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.domain.entities.CommentEntity
import dev.eduayuso.cleansamples.shared.domain.entities.PostEntity
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts.IPostDetailEvents
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.posts.PostDetailPresenter
import org.koin.java.KoinJavaComponent.inject

class PostDetailActivity:

    CleanActivity<IPostDetailEvents>(),
    IPostDetailEvents,
    OnTagClickListener {

    override val presenter by inject(PostDetailPresenter::class.java)
    override val layoutResourceId = R.layout.activity_post_detail

    private val progressBar by lazy { findViewById<ProgressBar>(R.id.commentsProgressBar) }
    private val tagsRecyclerView by lazy { findViewById<RecyclerView>(R.id.tagsRecyclerView) }
    private var tagRecyclerAdapter: TagMiniListRecyclerAdapter? = null
    private val commentsRecyclerView by lazy { findViewById<RecyclerView>(R.id.commentsRecyclerView) }
    private var commentsRecyclerAdapter: CommentListRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.configRecyclerView()

        if (intent.extras != null) {
            intent.extras?.getString(DataConstants.ViewArguments.postId).let {
                postId ->
                this.presenter.getPost(postId ?: "")
                this.presenter.fetchPostComments(postId ?: "")
            }
        }
    }

    private fun configRecyclerView() {

        /**
         * Tag list recycler
         */
        tagsRecyclerView?.let {
            val layoutManager = FlexboxLayoutManager(this)
            layoutManager.flexDirection = FlexDirection.ROW
            layoutManager.justifyContent = JustifyContent.CENTER
            layoutManager.alignItems = AlignItems.CENTER
            it.layoutManager = layoutManager
            tagRecyclerAdapter = TagMiniListRecyclerAdapter(this)
            it.adapter = tagRecyclerAdapter
        }

        /**
         * Comment list recycler
         */
        commentsRecyclerView?.let {
            it.layoutManager = GridLayoutManager(this, 1)
            it.setHasFixedSize(true)
            commentsRecyclerAdapter = CommentListRecyclerAdapter()
            it.adapter = commentsRecyclerAdapter
        }
    }

    override fun showLoading() {

        progressBar?.visibility = View.VISIBLE
    }

    override fun hideLoading() {

        progressBar?.visibility = View.GONE
    }

    override fun onPostDetailFetched(post: PostEntity, tags: List<TagEntity>) {

        findViewById<ImageView>(R.id.authorImageView)?.apply {
            bindAvatarUrl(post.owner?.picture)
        }

        findViewById<TextView>(R.id.authorNameTextView)?.apply {
            text = "${post.owner?.firstName} ${post.owner?.lastName}"
        }

        findViewById<ImageView>(R.id.postImageView)?.apply {
            bindImageUrl(post.image)
        }

        findViewById<TextView>(R.id.postTextView)?.apply {
            text = "${post.text}"
        }

        findViewById<TextView>(R.id.likesTextView)?.apply {
            text = "${post.likes}"
        }

        tagRecyclerAdapter?.addItems(tags)
    }

    override fun onPostCommentsFetched(comments: List<CommentEntity>) {

        progressBar?.visibility = View.GONE
        commentsRecyclerView?.visibility = View.VISIBLE
        commentsRecyclerAdapter?.addItems(comments)
    }

    override fun onError(message: String) {

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onTagClick(id: String) {

        val intent = Intent(this, TagDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.tagId, id)
        }
        startActivity(intent)
    }
}