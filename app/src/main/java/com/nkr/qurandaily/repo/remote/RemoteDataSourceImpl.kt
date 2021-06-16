package com.nkr.qurandaily.repo.remote

import com.nkr.qurandaily.model.ChapterInfoResponse
import com.nkr.qurandaily.model.VersesByChapterResponse
import com.nkr.qurandaily.service.QuranApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.nkr.qurandaily.repo.remote.Result


class RemoteDataSourceImpl : IRemoteDataSource {
    override suspend fun getChapterList(): Result<ChapterInfoResponse> {
      return withContext(Dispatchers.IO){
          try {
              val chapterInfoResponse = QuranApi.retrofitService.getChapters().await()
               Result.Success(chapterInfoResponse)
          }catch (e:Exception){
               Result.Error(e)
          }
      }
    }

    override suspend fun getVersesByChapter(chapter_number: Int): Result<VersesByChapterResponse> {
        return withContext(Dispatchers.IO){
            try {
                val verseResponse = QuranApi.retrofitService.getVerses(chapter_number).await()
                Result.Success(verseResponse)
            }catch (e:Exception){
                Result.Error(e)
            }
        }
    }

}