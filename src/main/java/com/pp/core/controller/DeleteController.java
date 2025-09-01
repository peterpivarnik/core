package com.pp.core.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.pp.core.controller.api.DeleteService;
import java.io.Serializable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic controller interface that provides functionality to delete entities by their ID.
 *
 * @param <S> the service type that implements DeleteService interface
 * @param <I> the type of the entity's identifier (must be Serializable)
 */
public interface DeleteController<I extends Serializable, S extends DeleteService<I>> {

    /**
     * Deletes an entity by its ID.
     * Returns HTTP 204 (No Content) on successful deletion.
     *
     * @param id the unique identifier of the entity to delete
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(NO_CONTENT)
    default void delete(@PathVariable("id") final I id) {
        getService().delete(id);
    }

    /**
     * Returns the service instance that provides entity deletion functionality.
     *
     * @return the service implementing DeleteService interface
     */
    S getService();

}
