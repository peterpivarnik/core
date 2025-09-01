package com.pp.core.service.dependencies;

import com.pp.core.dao.entity.BaseEntity;
import com.pp.core.service.mapper.ToEntityMapper;
import java.io.Serializable;

/**
 * Provider interface for ToEntityMapper instances. This interface defines a contract for obtaining
 * a mapper that can convert records to entities.
 *
 * @param <M> the type of the ToEntityMapper implementation
 * @param <R> the record type that represents the domain entity
 * @param <E> the entity type that extends BaseEntity
 * @param <I> the type of the entity's identifier (must be Serializable)
 */
public interface ToEntityMapperProvider<
    R extends Record,
    M extends ToEntityMapper<R, E>,
    I extends Serializable, E extends BaseEntity<I>> {

  /**
   * Returns the mapper instance that can convert records to entities.
   *
   * @return the ToEntityMapper implementation
   */
  M getToEntityMapper();
}
