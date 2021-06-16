package com.nkr.qurandaily.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass




@JsonClass(generateAdapter = true)
data class ChapterInfoResponse(
    val chapters : List<Chapter>
)


@JsonClass(generateAdapter = true)
data class Chapter(
    @Json(name = "id")  val id :Int,
    @Json(name = "revelation_place") val revelationPlace:String,
    @Json(name = "revelation_order") val revelationOrder:Int,
    @Json(name = "bismillah_pre") val bismillahPre:Boolean,
    @Json(name = "name_complex") val nameComplex:String,
    @Json(name = "name_arabic") val nameArabic:String,
    @Json(name = "verses_count")  val versesCount:Int,
    @Json(name = "pages")  val pages:List<Int>,
    @Json(name = "translated_name")val translatedName:TranslatedName
) {
    val chapter_num :String
        get() = id.toString()
}



@JsonClass(generateAdapter = true)
data class TranslatedName(
    @Json(name = "language_name")  val lName:String,
    @Json(name = "name")  val name:String,
)

//--------verses-----------------//

@JsonClass(generateAdapter = true)
data class VersesByChapterResponse(
    val verses : List<Verses>
)

@JsonClass(generateAdapter = true)
data class Verses(
    @Json(name = "id")  val id :Int,
    @Json(name = "chapter_id")  val chapterId :Int=0,
    @Json(name = "verse_number")  val verseNumber :Int,
    @Json(name = "text_uthmani")  val textUthmani :String?,
    @Json(name = "text_uthmani_simple")  val textUthmaniSimple :String
)
