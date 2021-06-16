package com.nkr.qurandaily.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nkr.qurandaily.model.ChapterInfoResponse
import com.nkr.qurandaily.model.VersesByChapterResponse
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_URL = "https://api.quran.com/api/v4/"

private val moshi = Moshi.Builder()
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


interface QuranApiService {
    // get all the list from
    @GET("chapters")
    fun getChapters(
    ): Deferred<ChapterInfoResponse>


    @GET("verses/by_chapter/{chapter_number}")
    fun getVerses(
        @Path("chapter_number") chapter_number : Int,
        @Query("fields") text : String = "text_uthmani,text_uthmani_simple"
    ): Deferred<VersesByChapterResponse>
}


object QuranApi {
    val retrofitService: QuranApiService by lazy {
        retrofit.create(QuranApiService::class.java)
    }
}


