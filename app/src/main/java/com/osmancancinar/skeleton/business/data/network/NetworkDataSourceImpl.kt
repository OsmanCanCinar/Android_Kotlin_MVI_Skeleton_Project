package com.osmancancinar.skeleton.business.data.network

import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.framework.data_source.network.RetrofitService
import com.osmancancinar.skeleton.framework.data_source.network.mappers.NetworkMapper

class NetworkDataSourceImpl constructor(
    private val retrofitService: RetrofitService,
    private val networkMapper: NetworkMapper
): NetworkDataSource {

    override suspend fun get(): List<Model> {
        return networkMapper.mapFromEntityList(retrofitService.get())
    }
}