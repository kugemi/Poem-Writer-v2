package dev.kugemi.rhymesapi

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import dev.kugemi.rhymesapi.models.LanguageSerializable
import dev.kugemi.rhymesapi.models.RhymeDTO
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * [API Documentation](https://rhymebrain.com/api.html#rhyme)
 */
interface RhymesApi {

    @GET("talk")
    fun getRhymes(
        @Query("function") function : String,
        @Query("word") word : String,
        @Query("lang") language : LanguageSerializable
    ): Result<List<RhymeDTO>>
}

fun RhymesApi(baseUrl: String, okHttpClient: OkHttpClient? = null, json: Json = Json): RhymesApi {
    return retrofit(baseUrl, okHttpClient, json).create()
}

private fun retrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient?,
    json: Json
): Retrofit {
    val jsonConverterFactory = json.asConverterFactory(MediaType.get("application/json"))

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverterFactory)
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .run { if (okHttpClient != null) client(okHttpClient) else this }
        .build()
}