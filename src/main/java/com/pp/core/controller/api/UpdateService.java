package com.pp.core.controller.api;

import java.io.Serializable;

/**
 * Interface for updating entities through their record representations.
 *
 * @param <I>  the type of the entity's identifier (must be Serializable)
 * @param <IR> the input record type used for update requests
 * @param <OR> the output record type representing the updated entity
 */
public interface UpdateService<I extends Serializable, IR extends Record, OR extends Record> {

    /**
     * Updates an existing entity identified by the given ID with the data from the provided record.
     *
     * @param id      the identifier of the entity to update
     * @param request the input record containing the updated data
     * @return the output record representing the updated entity
     */
    OR update(I id, IR request);
}
