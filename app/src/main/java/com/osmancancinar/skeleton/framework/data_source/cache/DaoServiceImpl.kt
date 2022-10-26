package com.osmancancinar.skeleton.framework.data_source.cache

import com.osmancancinar.skeleton.framework.data_source.cache.database.AppDao
import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity

class DaoServiceImpl constructor(
    private val dao: AppDao
) : DaoService {

    override suspend fun insert(cacheEntity: CacheEntity): Long {
        return dao.insert(cacheEntity)
    }

    override suspend fun getAll(): List<CacheEntity> {
        return dao.getAll()
    }

    override suspend fun get(id: Int): CacheEntity {
        return dao.get(id)
    }

    override suspend fun deleteAll() {
        return dao.deleteAll()
    }
}