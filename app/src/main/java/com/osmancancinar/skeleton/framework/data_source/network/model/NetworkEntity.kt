package com.osmancancinar.skeleton.framework.data_source.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//  Network Entities represent attributes of the network response object.
data class NetworkEntity(

    @SerializedName("pk")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("status")
    @Expose
    var status: String,

    @SerializedName("species")
    @Expose
    var species: String,

    @SerializedName("type")
    @Expose
    var type: String,

    @SerializedName("gender")
    @Expose
    var gender: String,

    @SerializedName("origin")
    @Expose
    var origin: String,

    @SerializedName("image")
    @Expose
    var image: String,
)