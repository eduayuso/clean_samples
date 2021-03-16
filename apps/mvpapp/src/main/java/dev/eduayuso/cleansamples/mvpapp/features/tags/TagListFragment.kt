package dev.eduayuso.cleansamples.mvpapp.features.tags

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import dev.eduayuso.cleansamples.mvpapp.R
import dev.eduayuso.cleansamples.mvpapp.components.ui.CleanFragment
import dev.eduayuso.cleansamples.mvpapp.features.users.UserListRecyclerAdapter
import dev.eduayuso.cleansamples.shared.domain.entities.TagEntity
import dev.eduayuso.cleansamples.shared.impl.DataConstants
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags.ITagListEvents
import dev.eduayuso.cleansamples.shared.presentation.mvp.features.tags.TagListPresenter
import org.koin.java.KoinJavaComponent.inject

class TagListFragment: CleanFragment<ITagListEvents>(), ITagListEvents, OnTagClickListener {

    override val presenter by inject(TagListPresenter::class.java)
    override val layoutResourceId = R.layout.fragment_tag_list

    private val progressBar by lazy { view?.findViewById<ProgressBar>(R.id.tagListProgressBar) }
    private val recyclerView by lazy { view?.findViewById<RecyclerView>(R.id.tagListRecyclerView) }
    private var recyclerAdapter: TagListRecyclerAdapter? = null

    override fun onResume() {

        super.onResume()
        this.presenter.fetchTags()
    }

    override fun showLoading() {

        progressBar?.visibility = View.VISIBLE
    }

    override fun hideLoading() {

        progressBar?.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        recyclerView?.let {
            val layoutManager = FlexboxLayoutManager(context)
            layoutManager.flexDirection = FlexDirection.ROW
            layoutManager.justifyContent = JustifyContent.CENTER
            layoutManager.alignItems = AlignItems.CENTER
            it.layoutManager = layoutManager
            recyclerAdapter = TagListRecyclerAdapter(this)
            it.adapter = recyclerAdapter
        }
    }

    override fun onTagClick(id: String) {

        val intent = Intent(context, TagDetailActivity::class.java).apply {
            putExtra(DataConstants.ViewArguments.tagId, id)
        }
        startActivity(intent)
    }

    override fun onTagListFetched(tags: List<TagEntity>) {

        recyclerAdapter?.addItems(tags)
    }
}