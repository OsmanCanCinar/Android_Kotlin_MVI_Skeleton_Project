package com.osmancancinar.skeleton.framework.data_source.network

import com.osmancancinar.skeleton.framework.data_source.network.model.NetworkEntity

interface RetrofitService {
    suspend fun get(): List<NetworkEntity>
}