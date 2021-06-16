package com.nkr.qurandaily.ui.fragment.chapterList

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nkr.qurandaily.base.BaseViewModel
import com.nkr.qurandaily.model.ChapterInfoResponse
import com.nkr.qurandaily.repo.remote.IRemoteDataSource
import kotlinx.coroutines.launch
import com.nkr.qurandaily.repo.remote.Result
import neel.com.quranapp.ui.fragments.chapters.ChapterListAdapter
import timber.log.Timber

class ChapterListViewModel(app:Application, val remote : IRemoteDataSource) : BaseViewModel(app) {
    val adapter = ChapterListAdapter()
    val chapter_list = MutableLiveData<ChapterInfoResponse>()

    fun getChapterList() = viewModelScope.launch {
       val chapter_resposne = remote.getChapterList()
        when(chapter_resposne){
            is Result.Success ->{
                chapter_resposne.data.let {
                    chapter_list.value = it
                }

                Timber.i("chapter_response_status : ${chapter_resposne.data}")
            }
            is Result.Error -> {
                Timber.i("chapter_response_status : Error")
            }
        }

    }

}