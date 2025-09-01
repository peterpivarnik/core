package com.pp.core.controller.dependencies;

import com.pp.core.controller.mapper.FromDtoMapper;

/**
 * Generic provider interface for FromDtoMapper instances that handle conversion from DTOs to domain records.
 *
 * @param <R> the record type that represents the domain entity
 * @param <M> the mapper type that converts DTOs to records
 * @param <D> the DTO type that will be converted to a record
 */
public interface FromCreateDtoMapperProvider<D, M extends FromDtoMapper<D, R>, R extends Record> {

    /**
     * Returns the mapper instance used to convert domain records to DTOs.
     *
     * @return the mapper instance implementing DtoMapper interface
     */
    M getFromCreateDtoMapper();
}
