package com.osmancancinar.skeleton.framework.data_source.cache.mappers

import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.business.domain.util.EntityMapper
import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity
import javax.inject.Inject

class CacheMapper
@Inject constructor() : EntityMapper<CacheEntity, Model> {

    override fun mapFromEntity(entity: CacheEntity): Model {
        return Model(
            id = entity.id,
            name = entity.name,
            status = entity.status,
            species = entity.species,
            type = entity.type,
            gender = entity.gender,
            origin = entity.origin,
            image = entity.image,
        );
    }

    override fun mapToEntity(model: Model): CacheEntity {
        return CacheEntity(
            id = model.id,
            name = model.name,
            status = model.status,
            species = model.species,
            type = model.type,
            gender = model.gender,
            origin = model.origin,
            image = model.image,
        );
    }

    fun mapFromEntityList(entities: List<CacheEntity>): List<Model> {
        return entities.map { mapFromEntity(it) }
    }
}
