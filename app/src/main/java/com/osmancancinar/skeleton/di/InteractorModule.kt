package com.osmancancinar.skeleton.di

import com.osmancancinar.skeleton.business.data.cache.CacheDataSource
import com.osmancancinar.skeleton.business.data.network.NetworkDataSource
import com.osmancancinar.skeleton.business.interactors.GetData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {

    @Singleton
    @Provides
    fun provideGetData(
        cacheDataSource: CacheDataSource,
        networkDataSource: NetworkDataSource
    ): GetData {
        return GetData(cacheDataSource, networkDataSource)
    }
}
