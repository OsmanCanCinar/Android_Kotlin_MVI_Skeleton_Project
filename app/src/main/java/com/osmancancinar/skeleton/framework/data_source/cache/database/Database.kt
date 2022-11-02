package com.osmancancinar.skeleton.framework.data_source.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity

/**
 *  The abstract database class that holds the Room database and serves as the main access point
 *  for the underlying connection to your app's persisted data.
 */
@Database(entities = [CacheEntity::class], version = 1)
abstract class Database : RoomDatabase() {

    // Database Access Object, we can other custom database access objects later.
    abstract fun appDao(): AppDao

    companion object {
        // Name of the Database
        const val DATABASE_NAME: String = "database"
    }
}