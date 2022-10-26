package com.osmancancinar.skeleton.business.data.network

import com.osmancancinar.skeleton.business.domain.models.Model

interface NetworkDataSource {
    suspend fun get(): List<Model>
}