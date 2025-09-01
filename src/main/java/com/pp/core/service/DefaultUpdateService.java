package com.pp.core.service;

import com.pp.core.controller.api.UpdateService;
import com.pp.core.dao.entity.BaseEntity;
import com.pp.core.dao.repository.BaseRepository;
import com.pp.core.service.dependencies.FromEntityMapperProvider;
import com.pp.core.service.dependencies.RepositoryProvider;
import com.pp.core.service.mapper.FromEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import java.io.Serializable;

/**
 * Default implementation of update operations for entities that extends BaseEntity.
 *
 * @param <I>   type of entity identifier, must extend Serializable
 * @param <E>   type of entity extending BaseEntity
 * @param <BR>  type of repository extending BaseRepository
 * @param <IR>  type of input record for update operations
 * @param <OR>  type of output record returned after update
 * @param <FEM> type of mapper that converts entities to output records
 */
public interface DefaultUpdateService<
    I extends Serializable,
    IR extends Record,
    E extends BaseEntity<I>,
    BR extends BaseRepository<I, E>,
    FEM extends FromEntityMapper<E, OR>,
    OR extends Record> extends UpdateService<I, IR, OR>,
                               RepositoryProvider<I, E, BR>,
                               FromEntityMapperProvider<I, E, FEM, OR> {

    /**
     * Updates an existing entity with the provided record data.
     *
     * @param id     identifier of the entity to update
     * @param record record containing the update data
     * @return updated entity mapped to record
     * @throws EntityNotFoundException if entity with given id is not found
     */
    @Override
    default OR update(I id, IR record) {
        return getRepository().findById(id)
                              .map(entity -> updateEntity(entity, record))
                              .map(entity -> getRepository().save(entity))
                              .map(entity -> getFromEntityMapper().toRecord(entity))
                              .orElseThrow(() -> new EntityNotFoundException("Entity with Id " + id + " not found!"));
    }

    /**
     * Updates the entity with data from the record.
     *
     * @param entity existing entity to be updated
     * @param record record containing the update data
     * @return updated entity
     */
    E updateEntity(E entity, IR record);
}
