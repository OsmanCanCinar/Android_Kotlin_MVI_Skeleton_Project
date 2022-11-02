package com.osmancancinar.skeleton.framework.data_source.network.service

import com.osmancancinar.skeleton.framework.data_source.network.model.NetworkEntity
import com.osmancancinar.skeleton.framework.data_source.network.retrofit.API

/**
 *  An Implementation class provides what exactly retrofit service does by doing interface delegation.
 */
class APIServiceImpl constructor(
    private val api: API
) : APIService {

    // Gets network entity by using api.
    override suspend fun get(): List<NetworkEntity> {
        return api.get()
    }
}