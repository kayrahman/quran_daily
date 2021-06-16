package com.nkr.qurandaily.repo.remote

import com.nkr.qurandaily.model.ChapterInfoResponse
import com.nkr.qurandaily.model.VersesByChapterResponse
import com.nkr.qurandaily.repo.remote.Result


interface IRemoteDataSource {
    suspend fun getChapterList() : Result<ChapterInfoResponse>
    suspend fun getVersesByChapter(chapter_number : Int) : Result<VersesByChapterResponse>
}