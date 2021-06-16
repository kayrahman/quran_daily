package com.nkr.qurandaily.ui.fragment.chapterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.AppBarLayout
import com.nkr.qurandaily.base.BaseFragment
import com.nkr.qurandaily.base.BaseViewModel
import com.nkr.qurandaily.base.NavigationCommand
import com.nkr.qurandaily.databinding.ChapterListFragmentBinding
import neel.com.quranapp.ui.fragments.chapters.ChapterListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChapterListFragment : BaseFragment() {

    private val viewModel: ChapterListViewModel by viewModel()
    override val _viewModel: BaseViewModel
        get() = viewModel

    private lateinit var binding :ChapterListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ChapterListFragmentBinding.inflate(inflater,container,false)
        coordinateMotion()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getChapterList()

    }


    private fun setupListener() {
        viewModel.adapter.chapter_listener =
            ChapterListAdapter.ChapterItemClickListener() {
                //go to chapter detail fragment
                val actionDetail = ChapterListFragmentDirections.actionChapterListFragmentToChapterDetailFragment()
                viewModel.navigationCommand.value = NavigationCommand.To(actionDetail)
            }
    }

    private fun coordinateMotion() {
        val listener = AppBarLayout.OnOffsetChangedListener { unused, verticalOffset ->
            val seekPosition = -verticalOffset / binding.appBar.totalScrollRange.toFloat()
            binding.layoutHeader.motionHeader.progress = seekPosition
        }

        binding.appBar.addOnOffsetChangedListener(listener)
    }



}