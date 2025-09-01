package com.pp.core.service;

import com.pp.core.controller.api.GetByIdService;
import com.pp.core.dao.entity.BaseEntity;
import com.pp.core.dao.repository.BaseRepository;
import com.pp.core.service.dependencies.FromEntityMapperProvider;
import com.pp.core.service.dependencies.RepositoryProvider;
import com.pp.core.service.mapper.FromEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import java.io.Serializable;

/**
 * Default implementation for retrieving entities by their ID and mapping them to records.
 *
 * @param <BR> type of the base repository
 * @param <E>  type of the entity extending BaseEntity
 * @param <I>  type of the entity identifier
 * @param <M>  type of the entity mapper
 * @param <R>  type of the record to map to
 */
public interface DefaultGetByIdService<
    I extends Serializable,
    E extends BaseEntity<I>,
    BR extends BaseRepository<I, E>,
    M extends FromEntityMapper<E, R>,
    R extends Record> extends GetByIdService<I, R>,
    FromEntityMapperProvider<I, E, M, R>,
    RepositoryProvider<I, E, BR> {

  /**
   * Retrieves an entity by its ID and maps it to a record.
   *
   * @param id the identifier of the entity to retrieve
   * @return mapped entity as a record
   * @throws EntityNotFoundException if no entity is found with the given ID
   */
  @Override
  default R getById(final I id) {
    return getRepository().findById(id)
                          .map(entity -> getFromEntityMapper().toRecord(entity))
                          .orElseThrow(() -> new EntityNotFoundException("Entity with Id " + id + " not found!"));
  }
}
