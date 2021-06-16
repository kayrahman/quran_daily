package neel.com.quranapp.ui.fragments.chapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nkr.qurandaily.R
import com.nkr.qurandaily.databinding.ListItemChapterBinding
import com.nkr.qurandaily.model.Chapter
import timber.log.Timber


class ChapterListAdapter : ListAdapter<Chapter, ChapterListAdapter.ChapterListItemViewHolder>(
    CartListDiffUtilCallback()
)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterListItemViewHolder {
        val binding: ListItemChapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_chapter, parent, false)

        return ChapterListItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ChapterListItemViewHolder, position: Int) {
        getItem(position).let { chapter ->
            holder.bind(chapter)
            holder.binding.rootCly.setOnClickListener {
                chapter_listener.onChapterListItemClick(chapter.id)
            }
        }
    }


    class CartListDiffUtilCallback : DiffUtil.ItemCallback<Chapter>(){
        override fun areItemsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class ChapterListItemViewHolder(val binding : ListItemChapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Chapter){
            binding.chapter = item
            binding.executePendingBindings()
        }
    }
    /**
     * listener class related
     */

    lateinit var chapter_listener : ChapterItemClickListener
    class ChapterItemClickListener(val listener: (Int) -> Unit) {
        fun onChapterListItemClick(chapter_id : Int) = listener(chapter_id)

    }

}
