package com.pp.core.dao.repository;

import com.pp.core.dao.entity.BaseEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Base repository interface that combines Spring Data JPA's standard repository functionality with
 * specification execution capabilities. This interface serves as a foundation for all repositories
 * in the application that need both basic CRUD operations and dynamic query capabilities.
 *
 * @param <E> the entity type that extends BaseEntity
 * @param <I> the type of the entity's identifier (primary key) that implements Serializable
 */
public interface BaseRepository<I extends Serializable, E extends BaseEntity<I>>
    extends JpaRepository<E, I>, JpaSpecificationExecutor<E> {
}
