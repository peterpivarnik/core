package com.pp.core.controller.mapper;


/**
 * Interface for mapping Data Transfer Objects (DTOs) to records.
 *
 * @param <R> the type of the record that will be produced
 * @param <D> the type of the DTO that will be mapped
 */
public interface FromDtoMapper<D, R extends Record> {

    /**
     * Map DTO to record.
     *
     * @param record DTO to be mapped
     * @return mapped record
     */
    R fromDto(D record);
}
