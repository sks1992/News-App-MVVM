package sk.sandeep.newsappmvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sk.sandeep.newsappmvvm.network.NewsApi
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NewsModule {
    @Singleton
    @Provides
    fun provideNewsApi(): NewsApi {
        return NewsApi.create()
    }
}