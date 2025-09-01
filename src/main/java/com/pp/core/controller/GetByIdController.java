package com.pp.core.controller;

import static org.springframework.http.HttpStatus.OK;

import com.pp.core.controller.api.GetByIdService;
import com.pp.core.controller.dependencies.ToDtoMapperProvider;
import com.pp.core.controller.mapper.ToDtoMapper;
import java.io.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic controller interface that provides functionality to retrieve entities by their ID
 * and map them to DTOs.
 *
 * @param <S> the service type that implements ByIdGetter interface
 * @param <I> the type of the entity's identifier (must be Serializable)
 * @param <R> the record type that represents the domain entity
 * @param <M> the mapper type that converts records to DTOs
 * @param <D> the DTO type returned to the client (must be Serializable)
 */
public interface GetByIdController<
    I extends Serializable,
    S extends GetByIdService<I, R>,
    R extends Record,
    M extends ToDtoMapper<R, D>,
    D
    > extends ToDtoMapperProvider<R, M, D> {

    /**
     * Gets data by provided id.
     *
     * @param id id of the entity
     * @return mapped entity to DTO
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(OK)
    @ResponseBody
    default D getById(@PathVariable("id") final I id) {
        R record = getService().getById(id);
        return getToDtoMapper().toDto(record);
    }

    /**
     * Returns the service instance that provides entity retrieval functionality.
     *
     * @return the service implementing ByIdGetter interface
     */
    S getService();
}
