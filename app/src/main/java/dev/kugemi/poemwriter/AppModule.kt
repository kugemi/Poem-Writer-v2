package dev.kugemi.poemwriter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kugemi.rhymesapi.RhymesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesRhymesApi(): RhymesApi {
        return RhymesApi(
            baseUrl = BuildConfig.RHYMES_API_BASE_URL
        )
    }
}