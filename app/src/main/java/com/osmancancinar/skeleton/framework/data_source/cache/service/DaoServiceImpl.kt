package com.osmancancinar.skeleton.framework.data_source.cache.service

import com.osmancancinar.skeleton.framework.data_source.cache.database.AppDao
import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity

/**
 *  An Implementation class provides what exactly dao service does by doing interface delegation.
 */

class DaoServiceImpl constructor(
    private val dao: AppDao
) : DaoService {

    // Inserts cache entity by using dao.
    override suspend fun insert(cacheEntity: CacheEntity): Long {
        return dao.insert(cacheEntity)
    }

    // Selects all of cache entities and returns them as a list by using dao.
    override suspend fun getAll(): List<CacheEntity> {
        return dao.getAll()
    }

    // Selects cache entity with given id and returns it by using dao.
    override suspend fun get(id: Int): CacheEntity {
        return dao.get(id)
    }

    // Deletes all of cache entities by using dao.
    override suspend fun deleteAll() {
        return dao.deleteAll()
    }
}