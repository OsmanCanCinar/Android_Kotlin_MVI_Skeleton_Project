package com.osmancancinar.skeleton.business.data.network

import com.osmancancinar.skeleton.business.domain.models.Model

/**
 *  An Interface class to provide a description of what a network data source can do.
 */
interface NetworkDataSource {

    // Gets all of the Network Models from api and returns a list of data models for UI.
    suspend fun get(): List<Model>
}