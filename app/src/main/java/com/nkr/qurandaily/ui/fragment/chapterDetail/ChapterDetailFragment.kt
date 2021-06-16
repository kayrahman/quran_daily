package com.nkr.qurandaily.ui.fragment.chapterDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nkr.qurandaily.R
import com.nkr.qurandaily.base.BaseFragment
import com.nkr.qurandaily.base.BaseViewModel
import com.nkr.qurandaily.databinding.ChapterDetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChapterDetailFragment : BaseFragment() {

    private val viewModel: ChapterDetailViewModel by viewModel()
    private lateinit var binding : ChapterDetailFragmentBinding
    override val _viewModel: BaseViewModel
        get() = viewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ChapterDetailFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getVerses()

    }

}