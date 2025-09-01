package com.pp.core.service.dependencies;

import com.pp.core.dao.entity.BaseEntity;
import com.pp.core.dao.repository.BaseRepository;
import com.pp.core.service.mapper.FromEntityMapper;
import com.pp.core.service.mapper.ToEntityMapper;
import java.io.Serializable;

/**
 * ServiceDependencies is a generic interface that provides a comprehensive dependency management
 * structure for services handling entities, their mappers, and repositories. It ensures the service
 * has access to repository instances and mappers needed to manage entity-to-record and record-to-entity
 * transformations, and to perform entity persistence operations consistently.
 *
 * @param <I>   the type of the entity's identifier, which must be Serializable
 * @param <E>   the type of the entity extending BaseEntity
 * @param <IR>  the record type that is mapped to an entity for input operations
 * @param <OR>  the record type that is mapped from an entity for output operations
 * @param <TEM> the mapper type that maps input records to entity objects (ToEntityMapper)
 * @param <BR>  the type of the repository handling the entity operations (extends BaseRepository)
 * @param <FEM> the mapper type that maps entities to output records (FromEntityMapper)
 */
public interface ServiceDependencies<
    IR extends Record,
    TEM extends ToEntityMapper<IR, E>,
    I extends Serializable,
    E extends BaseEntity<I>,
    BR extends BaseRepository<I, E>,
    FEM extends FromEntityMapper<E, OR>,
    OR extends Record> extends RepositoryProvider<I, E, BR>,
                               FromEntityMapperProvider<I, E, FEM, OR>,
                               ToEntityMapperProvider<IR, TEM, I, E> {
}
