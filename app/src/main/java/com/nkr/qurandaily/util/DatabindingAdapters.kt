package neel.com.quranapp.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nkr.qurandaily.model.Chapter
import neel.com.quranapp.ui.fragments.chapters.ChapterListAdapter
import timber.log.Timber


@BindingAdapter("listData", "adapter")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<Chapter>?,
    adapter: ChapterListAdapter
) {
    // val adapter = CartListGridAdapter()
    recyclerView.adapter = adapter
    val layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.layoutManager = layoutManager
    Timber.i("cartListSize ${data?.size.toString()}")
    adapter.submitList(data)
}