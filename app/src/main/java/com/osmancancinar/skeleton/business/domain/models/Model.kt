package com.osmancancinar.skeleton.business.domain.models

/**
 * Data model that will be displayed in the UI.
 */
data class Model(
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var origin: String,
    var image: String,
)