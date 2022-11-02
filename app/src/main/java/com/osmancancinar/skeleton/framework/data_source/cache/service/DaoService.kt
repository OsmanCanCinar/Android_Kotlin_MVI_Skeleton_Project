package com.osmancancinar.skeleton.framework.data_source.cache.service

import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity

/**
 *  An Interface class to provide a description of what a dao service can do.
 */

interface DaoService {

    // Inserts Cache Entity to database and returns the id of the inserted item.
    suspend fun insert(cacheEntity: CacheEntity): Long

    // Selects all of the Cache Entities from database and returns it as a list.
    suspend fun getAll(): List<CacheEntity>

    // Selects the Cache Entity with given id and returns it.
    suspend fun get(id: Int): CacheEntity

    // Deletes all the Cache Entities in the table.
    suspend fun deleteAll()
}