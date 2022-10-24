package com.osmancancinar.skeleton.business.data.cache

import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.framework.data_source.cache.DaoService
import com.osmancancinar.skeleton.framework.data_source.cache.mappers.CacheMapper

class CacheDataSourceImpl
constructor(
    private val daoService: DaoService,
    private val cacheMapper: CacheMapper
) : CacheDataSource {

    override suspend fun insert(model: Model): Long {
        return daoService.insert(cacheMapper.mapToEntity(model))
    }

    override suspend fun insertList(models: List<Model>) {
        for (model in models) {
            daoService.insert(cacheMapper.mapToEntity(model))
        }
    }

    override suspend fun get(): List<Model> {
        return cacheMapper.mapFromEntityList(daoService.get())
    }
}