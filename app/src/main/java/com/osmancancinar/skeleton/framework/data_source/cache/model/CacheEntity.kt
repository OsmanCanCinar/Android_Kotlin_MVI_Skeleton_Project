package com.osmancancinar.skeleton.framework.data_source.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cached_response")
data class CacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "species")
    var species: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "gender")
    var gender: String,

    @ColumnInfo(name = "origin")
    var origin: String,

    @ColumnInfo(name = "image")
    var image: String,
)