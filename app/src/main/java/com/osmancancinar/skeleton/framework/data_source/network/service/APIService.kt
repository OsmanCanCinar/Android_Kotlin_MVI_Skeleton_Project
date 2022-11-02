package com.osmancancinar.skeleton.framework.data_source.network.service

import com.osmancancinar.skeleton.framework.data_source.network.model.NetworkEntity

/**
 *  An Interface class to provide a description of what a retrofit service can do.
 */
interface APIService {

    // Gets data from the network and returns list of network entities in the response.
    suspend fun get(): List<NetworkEntity>
}