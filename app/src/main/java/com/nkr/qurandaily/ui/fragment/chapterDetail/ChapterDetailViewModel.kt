package com.nkr.qurandaily.ui.fragment.chapterDetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nkr.qurandaily.base.BaseViewModel
import com.nkr.qurandaily.repo.remote.IRemoteDataSource
import kotlinx.coroutines.launch
import com.nkr.qurandaily.repo.remote.Result
import timber.log.Timber

class ChapterDetailViewModel(app:Application,val remote:IRemoteDataSource) : BaseViewModel(app) {

    fun getVerses() = viewModelScope.launch {
        val verses_response = remote.getVersesByChapter(2)
        when(verses_response){
            is Result.Success ->{
                Timber.i("verse_response_status : ${verses_response.data}")
            }
            is Result.Error -> {
                Timber.i("verse_response_status : ${verses_response.exception}")
            }
        }
    }

}