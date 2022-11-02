package com.osmancancinar.skeleton.business.interactors

import com.osmancancinar.skeleton.business.data.cache.CacheDataSource
import com.osmancancinar.skeleton.business.data.network.NetworkDataSource
import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.business.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Get Data Manages data state and interactions of the App by using cache and network data sources.
 */
class GetData constructor(
    private val cacheDataSource: CacheDataSource,
    private val networkDataSource: NetworkDataSource
) {

    // get from network and store in db
    suspend fun execute(): Flow<DataState<List<Model>>> = flow {
        emit(DataState.Loading)
        val networkModels = networkDataSource.get()
        cacheDataSource.insertAll(networkModels)
        val cachedModels = cacheDataSource.getAll()
        emit(DataState.Success(cachedModels))
    }

    // get from db
    suspend fun executeDetail(itemId: Int): Flow<DataState<Model>> = flow {
        emit(DataState.Loading)
        val cachedModels = cacheDataSource.get(itemId)
        emit(DataState.Success(cachedModels))
    }
}