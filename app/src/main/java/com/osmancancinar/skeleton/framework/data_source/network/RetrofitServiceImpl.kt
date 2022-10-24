package com.osmancancinar.skeleton.framework.data_source.network

import com.osmancancinar.skeleton.framework.data_source.network.model.NetworkEntity
import com.osmancancinar.skeleton.framework.data_source.network.retrofit.API

class RetrofitServiceImpl constructor(
    private val api: API
) : RetrofitService{

    override suspend fun get(): List<NetworkEntity> {
        return api.get()
    }
}