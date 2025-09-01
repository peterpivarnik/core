package com.pp.core.service.dependencies;

import com.pp.core.dao.entity.BaseEntity;
import com.pp.core.service.mapper.FromEntityMapper;
import java.io.Serializable;

/**
 * Provider interface for obtaining FromEntityMapper instances that convert entities to records.
 *
 * @param <I> the type of the entity's identifier (must be Serializable)
 * @param <E> the entity type that extends BaseEntity
 * @param <R> the record type that represents the domain entity
 * @param <M> the mapper type that converts entities to records
 */
public interface FromEntityMapperProvider<
    I extends Serializable,
    E extends BaseEntity<I>,
    M extends FromEntityMapper<E, R>,
    R extends Record> {

  /**
   * Returns the mapper instance that converts entities to records.
   *
   * @return the mapper instance implementing FromEntityMapper interface
   */
  M getFromEntityMapper();
}
