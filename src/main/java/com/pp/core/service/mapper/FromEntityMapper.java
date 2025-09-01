package com.pp.core.service.mapper;

import com.pp.core.dao.entity.BaseEntity;

/**
 * Interface for mapping entities to records.
 *
 * @param <E> type of entity that extends BaseEntity
 * @param <R> type of record to be mapped to
 */
public interface FromEntityMapper<E extends BaseEntity<?>, R extends Record> {

    /**
     * Maps entity to record.
     *
     * @param entity entity to be mapped
     * @return mapped record
     */
    R toRecord(E entity);
}
