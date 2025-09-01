package com.pp.core.service;

import com.pp.core.controller.api.CreateService;
import com.pp.core.dao.entity.BaseEntity;
import com.pp.core.dao.repository.BaseRepository;
import com.pp.core.service.dependencies.ServiceDependencies;
import com.pp.core.service.mapper.FromEntityMapper;
import com.pp.core.service.mapper.ToEntityMapper;
import java.io.Serializable;

/**
 * DefaultCreateService is a default implementation of the CreateService interface, providing
 * functionality to create new entities from input records and map them to output records.
 * This interface combines the entity creation operation with the service dependency requirements,
 * such as a repository for persistence and mappers for data transformation.
 *
 * @param <I>   the type of the identifier for the entity, which must be Serializable
 * @param <E>   the type of the entity, which extends BaseEntity
 * @param <IR>  the record type that is mapped to an entity for input operations
 * @param <OR>  the record type that is mapped from an entity for output operations
 * @param <TEM> the mapper type that maps input records to entities (ToEntityMapper)
 * @param <BR>  the repository type handling entity persistence (BaseRepository)
 * @param <FEM> the mapper type that maps entities to output records (FromEntityMapper)
 */
public interface DefaultCreateService<
    IR extends Record,
    TEM extends ToEntityMapper<IR, E>,
    I extends Serializable,
    E extends BaseEntity<I>,
    BR extends BaseRepository<I, E>,
    FEM extends FromEntityMapper<E, OR>,
    OR extends Record> extends CreateService<IR, OR>, ServiceDependencies<IR, TEM, I, E, BR, FEM, OR> {

  /**
   * Creates new entity from request data and returns mapped inputRecord.
   *
   * @param inputRecord data for creating new entity
   * @return outputRecord mapped from saved entity
   */
  @Override
  default OR create(IR inputRecord) {
    E entity = getToEntityMapper().toEntity(inputRecord);
    E savedEntity = getRepository().save(entity);
    return getFromEntityMapper().toRecord(savedEntity);
  }
}
