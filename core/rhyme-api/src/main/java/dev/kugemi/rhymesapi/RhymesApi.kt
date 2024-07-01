package dev.kugemi.rhymesapi

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import dev.kugemi.rhymesapi.models.LanguageSerializable
import dev.kugemi.rhymesapi.models.RhymeDTO
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.IOException
import java.util.Locale


/**
 * [API Documentation](https://rhymebrain.com/api.html#rhyme)
 */
interface RhymesApi {

    @GET("talk")
    suspend fun getRhymes(
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

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val modifiedOkHttpClient =
        (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
            .addInterceptor(loggingInterceptor)
            .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(modifiedOkHttpClient)
        .build()
}