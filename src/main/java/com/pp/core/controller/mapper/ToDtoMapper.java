package com.pp.core.controller.mapper;

/**
 * Interface for mapping records to Data Transfer Objects (DTOs).
 *
 * @param <R> the type of the record that will be mapped
 * @param <D> the type of the DTO that will be produced
 */
public interface ToDtoMapper<R extends Record, D> {

  /**
   * Map record to dto.
   *
   * @param record record to be mapped
   * @return mapped dto
   */
  D toDto(R record);
}
