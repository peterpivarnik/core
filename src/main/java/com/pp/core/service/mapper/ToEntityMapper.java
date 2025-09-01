package com.pp.core.service.mapper;

import com.pp.core.dao.entity.BaseEntity;

/**
 * Interface for mapping records to entity objects.
 *
 * @param <E> the type of entity that extends BaseEntity
 * @param <R> the type record to be mapped
 */
public interface ToEntityMapper<R extends Record, E extends BaseEntity<?>> {

    /**
     * Maps the provided data object to an entity.
     *
     * @param record the data object to be mapped to an entity
     * @return the mapped entity instance
     */
    E toEntity(R record);
}
