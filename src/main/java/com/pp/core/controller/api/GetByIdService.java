package com.pp.core.controller.api;

import java.io.Serializable;

/**
 * Interface to get entity by id.
 *
 * @param <I> type of entity id
 * @param <R> type of returned record
 */
public interface GetByIdService<I extends Serializable, R extends Record> {

  /**
   * Gets entity by its id.
   *
   * @param id id of the entity
   * @return mapped entity to record
   */
  R getById(final I id);
}
