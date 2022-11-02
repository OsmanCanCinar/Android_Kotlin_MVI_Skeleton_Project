package com.osmancancinar.skeleton.business.domain.util.mappers

/**
 *  An Interface class to provide a description of what a Entity Mapper can do.
 */
interface EntityMapper<Entity, Model> {

    // Converts given Cache/Network Entity to Model.
    fun mapFromEntity(entity: Entity): Model

    // Converts given Model to Cache/Network Entity.
    fun mapToEntity(model: Model): Entity
}