package com.osmancancinar.skeleton.framework.data_source.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: CacheEntity): Long

    @Query("SELECT * FROM cached_response")
    suspend fun getAll(): List<CacheEntity>

    @Query("SELECT * FROM cached_response WHERE id = :id")
    suspend fun get(id: Int): CacheEntity

    @Query("DELETE FROM cached_response")
    suspend fun deleteAll()
}