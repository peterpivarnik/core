package com.pp.core.controller.dependencies;

import com.pp.core.controller.mapper.ToDtoMapper;

/**
 * Generic provider interface for ToDtoMapper instances that handle conversion from domain records to DTOs.
 *
 * @param <R> the record type that represents the domain entity
 * @param <D> the DTO type that will be produced from the record
 * @param <M> the mapper type that converts records to DTOs
 */
public interface ToDtoMapperProvider<R extends Record, M extends ToDtoMapper<R, D>, D> {

  /**
   * Returns a ToDtoMapper instance that can convert domain records to DTOs.
   *
   * @return the mapper instance for converting records to DTOs
   */
  M getToDtoMapper();
}
