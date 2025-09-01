package com.pp.core.service;

import com.pp.core.controller.api.DeleteService;
import com.pp.core.dao.entity.BaseEntity;
import com.pp.core.dao.repository.BaseRepository;
import com.pp.core.service.dependencies.RepositoryProvider;
import java.io.Serializable;

/**
 * Default implementation of DeleteService, providing basic delete functionality for entities
 * based on their ID. This implementation utilizes a repository to perform the delete operation.
 *
 * @param <BR> the type of the base repository, extending BaseRepository
 * @param <E>  the type of the entity, extending BaseEntity
 * @param <I>  the type of the entity's identifier, extending Serializable
 */
public interface DefaultDeleteService<I extends Serializable, E extends BaseEntity<I>, BR extends BaseRepository<I, E>>
    extends DeleteService<I>, RepositoryProvider<I, E, BR> {

  /**
   * Deletes an entity with the specified ID using the underlying repository.
   * This default implementation delegates the delete operation to the repository's
   * deleteById method.
   *
   * @param id the identifier of the entity to be deleted
   */
  @Override
  default void delete(I id) {
    getRepository().deleteById(id);
  }
}
