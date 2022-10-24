package com.osmancancinar.skeleton.framework.data_source.network.retrofit

import com.osmancancinar.skeleton.framework.data_source.network.model.NetworkEntity
import retrofit2.http.GET

interface API {

    @GET(value = "Placeholder_JSON/posts")
    suspend fun get(): List<NetworkEntity>
}