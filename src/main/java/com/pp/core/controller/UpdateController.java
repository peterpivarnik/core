package com.pp.core.controller;

import static org.springframework.http.HttpStatus.OK;

import com.pp.core.controller.api.UpdateService;
import com.pp.core.controller.dependencies.ControllerDependencies;
import com.pp.core.controller.mapper.FromDtoMapper;
import com.pp.core.controller.mapper.ToDtoMapper;
import java.io.Serializable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic controller interface that provides functionality to update entities and map them between DTOs
 * and domain records.
 *
 * @param <IR>  the input record type that represents the domain entity
 * @param <OR>  the output record type that represents the domain entity
 * @param <ID>  the input DTO type used for client communication
 * @param <OD>  the output DTO type used for client communication
 * @param <FDM> the mapper type that converts DTOs to records
 * @param <I>   the type of the entity's identifier (must be Serializable)
 * @param <S>   the service type that implements UpdateService interface
 * @param <TDM> the mapper type that converts records to DTOs
 */
public interface UpdateController<
    I extends Serializable,
    ID,
    FDM extends FromDtoMapper<ID, IR>,
    IR extends Record,
    S extends UpdateService<I, IR, OR>,
    OR extends Record,
    TDM extends ToDtoMapper<OR, OD>,
    OD
    > extends ControllerDependencies<ID, IR, FDM, OR, TDM, OD> {

  /**
   * Updates an existing entity with the provided data.
   *
   * @param id      the identifier of the entity to update
   * @param request the DTO containing the update data
   * @return the updated entity converted to DTO
   */
  @PutMapping(value = "/{id}")
  @ResponseStatus(OK)
  @ResponseBody
  default OD update(@PathVariable("id") final I id, @RequestBody final ID request) {
    IR requestRecord = getFromUpdateDtoMapper().fromDto(request);
    OR responseRecord = getService().update(id, requestRecord);
    return getToDtoMapper().toDto(responseRecord);
  }

  /**
   * Returns the service instance that provides entity update functionality.
   *
   * @return the service implementing UpdateService interface
   */
  S getService();

  @Override
  FDM getFromUpdateDtoMapper();
}
