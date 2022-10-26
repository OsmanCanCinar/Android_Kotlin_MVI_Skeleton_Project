package com.osmancancinar.skeleton.business.data.cache

import com.osmancancinar.skeleton.business.domain.models.Model

interface CacheDataSource {

    suspend fun insert(model: Model): Long

    suspend fun insertAll(models: List<Model>)

    suspend fun getAll(): List<Model>

    suspend fun get(id: Int): Model

    suspend fun deleteAll()
}