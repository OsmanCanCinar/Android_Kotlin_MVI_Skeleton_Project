package com.osmancancinar.skeleton.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.osmancancinar.skeleton.business.data.network.NetworkDataSource
import com.osmancancinar.skeleton.business.data.network.NetworkDataSourceImpl
import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.business.domain.util.EntityMapper
import com.osmancancinar.skeleton.framework.data_source.network.RetrofitService
import com.osmancancinar.skeleton.framework.data_source.network.RetrofitServiceImpl
import com.osmancancinar.skeleton.framework.data_source.network.mappers.NetworkMapper
import com.osmancancinar.skeleton.framework.data_source.network.model.NetworkEntity
import com.osmancancinar.skeleton.framework.data_source.network.retrofit.API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesNetworkMapper(): EntityMapper<NetworkEntity, Model> {
        return NetworkMapper()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/OsmanCanCinar/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit.Builder): API {
        return retrofit.build()
            .create(API::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofitService(api: API): RetrofitService {
        return RetrofitServiceImpl(api)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(
        retrofitService: RetrofitService,
        networkMapper: NetworkMapper
    ): NetworkDataSource {
        return NetworkDataSourceImpl(retrofitService, networkMapper)
    }
}