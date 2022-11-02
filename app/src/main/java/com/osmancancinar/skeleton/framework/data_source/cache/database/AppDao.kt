package com.osmancancinar.skeleton.framework.data_source.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity

// Database Access Object with custom interaction queries.
@Dao
interface AppDao {

    // Inserts a single item and returns the id of the item as Long.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: CacheEntity): Long

    // Selects and returns all items from the table.
    @Query("SELECT * FROM cached_response")
    suspend fun getAll(): List<CacheEntity>

    // Selects and returns the item with given id.
    @Query("SELECT * FROM cached_response WHERE id = :id")
    suspend fun get(id: Int): CacheEntity

    // Deletes all items in the table.
    @Query("DELETE FROM cached_response")
    suspend fun deleteAll()
}