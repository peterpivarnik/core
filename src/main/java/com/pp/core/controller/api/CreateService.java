package com.pp.core.controller.api;

/**
 * Interface providing the ability to create new entities from request data.
 *
 * @param <IR> the input record type representing the creation request data
 * @param <OR> the output record type representing the created entity
 */
public interface CreateService<IR extends Record, OR extends Record> {

    /**
     * Creates a new entity from the provided request data.
     *
     * @param request the data used to create the new entity
     * @return the created entity as a record
     */
    OR create(IR request);
}
