package com.osmancancinar.skeleton.business.data.network

import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.framework.data_source.network.service.APIService
import com.osmancancinar.skeleton.framework.data_source.network.mappers.NetworkMapper

/**
 * Achieving Code reusability thru composition by Interface Delegation. Uses api service and network mappers.
 */
class NetworkDataSourceImpl constructor(
    private val APIService: APIService,
    private val networkMapper: NetworkMapper
) : NetworkDataSource {
    // Gets all of the Network Models from api and returns a list of data models for UI.
    override suspend fun get(): List<Model> {
        return networkMapper.mapFromEntityList(APIService.get())
    }
}