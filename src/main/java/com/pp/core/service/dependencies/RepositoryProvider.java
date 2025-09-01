package com.pp.core.service.dependencies;

import com.pp.core.dao.entity.BaseEntity;
import java.io.Serializable;
import com.pp.core.dao.repository.BaseRepository;

/**
 * Generic interface for providing access to repository instances. This interface acts as a repository
 * factory or accessor that ensures consistent access to repository objects throughout the application.
 *
 * @param <I>  the type of identifier (primary key) implementing Serializable
 * @param <E>  the type of entity extending BaseEntity
 * @param <BR> the type of repository extending BaseRepository
 */
public interface RepositoryProvider<I extends Serializable, E extends BaseEntity<I>, BR extends BaseRepository<I, E>> {

    /**
     * Returns repository instance used for entity operations.
     *
     * @return repository instance
     */
    BR getRepository();
}
