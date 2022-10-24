package com.osmancancinar.skeleton.business.data.cache

import com.osmancancinar.skeleton.business.domain.models.Model

interface CacheDataSource {

    suspend fun insert(model: Model): Long

    suspend fun insertList(models: List<Model>)

    suspend fun get(): List<Model>
}