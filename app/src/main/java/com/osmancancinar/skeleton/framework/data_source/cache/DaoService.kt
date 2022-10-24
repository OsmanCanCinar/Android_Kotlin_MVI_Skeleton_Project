package com.osmancancinar.skeleton.framework.data_source.cache

import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity

interface DaoService {

    suspend fun insert(cacheEntity: CacheEntity): Long

    suspend fun get(): List<CacheEntity>
}