package com.osmancancinar.skeleton.business.interactors

import com.osmancancinar.skeleton.business.data.cache.CacheDataSource
import com.osmancancinar.skeleton.business.data.network.NetworkDataSource
import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.business.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetData constructor(
    private val cacheDataSource: CacheDataSource,
    private val networkDataSource: NetworkDataSource
) {

    suspend fun execute(): Flow<DataState<List<Model>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        val networkBlogs = networkDataSource.get()
        cacheDataSource.insertList(networkBlogs)
        val cachedBlogs = cacheDataSource.get()
        emit(DataState.Success(cachedBlogs))
    }

}