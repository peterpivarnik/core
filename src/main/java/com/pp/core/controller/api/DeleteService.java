package com.pp.core.controller.api;

import java.io.Serializable;

/**
 * Generic service interface that provides functionality to delete entities by their ID.
 *
 * @param <I> the type of the entity's identifier (must be Serializable)
 */
public interface DeleteService<I extends Serializable> {

  /**
   * Deletes an entity by its ID.
   *
   * @param id the identifier of the entity to delete
   */
  void delete(I id);
}
