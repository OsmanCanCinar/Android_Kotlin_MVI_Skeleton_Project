package com.osmancancinar.skeleton.business.data.cache

import com.osmancancinar.skeleton.business.domain.models.Model

/**
 *  An Interface class to provide a description of what a catch data source can do.
 */

interface CacheDataSource {

    // Inserts Data Model to database and returns the id of the inserted item id.
    suspend fun insert(model: Model): Long

    // Inserts set of Data Models to database.
    suspend fun insertAll(models: List<Model>)

    // Selects all of the Cache Entities from database and returns it a list of data models for UI.
    suspend fun getAll(): List<Model>

    // Selects the Data Model with given id and returns it.
    suspend fun get(id: Int): Model

    // Deletes all the Data Models in the table.
    suspend fun deleteAll()
}