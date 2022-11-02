package com.osmancancinar.skeleton.business.data.cache

import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.framework.data_source.cache.service.DaoService
import com.osmancancinar.skeleton.framework.data_source.cache.mappers.CacheMapper

/**
 * Achieving Code reusability thru composition by Interface Delegation. Uses dao service and catch mappers.
 */
class CacheDataSourceImpl
constructor(
    private val daoService: DaoService,
    private val cacheMapper: CacheMapper
) : CacheDataSource {

    // Inserts data model by using dao service.
    override suspend fun insert(model: Model): Long {
        return daoService.insert(cacheMapper.mapToEntity(model))
    }

    // Inserts data models by using dao service.
    override suspend fun insertAll(models: List<Model>) {
        for (model in models) {
            daoService.insert(cacheMapper.mapToEntity(model))
        }
    }

    // Selects all of data models and returns them as a list by using dao service.
    override suspend fun getAll(): List<Model> {
        return cacheMapper.mapFromEntityList(daoService.getAll())
    }

    // Selects data model with given id and returns it by using dao service.
    override suspend fun get(id: Int): Model {
        return cacheMapper.mapFromEntity(daoService.get(id))
    }

    // Deletes all of data models by using dao service.
    override suspend fun deleteAll() {
        return daoService.deleteAll()
    }
}