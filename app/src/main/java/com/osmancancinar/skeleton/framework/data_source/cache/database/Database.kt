package com.osmancancinar.skeleton.framework.data_source.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity

@Database(entities = [CacheEntity::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object {
        const val DATABASE_NAME: String = "database"
    }

}