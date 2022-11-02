package com.osmancancinar.skeleton.framework.data_source.network.retrofit

import com.osmancancinar.skeleton.framework.data_source.network.model.NetworkEntity
import retrofit2.http.GET

/**
 *  The API Interface class describes custom interactions with endpoints.
 */
interface API {

    // Gets data from the specified endpoint and returns list of network entities in the response.
    @GET(value = "Placeholder_JSON/posts")
    suspend fun get(): List<NetworkEntity>
}