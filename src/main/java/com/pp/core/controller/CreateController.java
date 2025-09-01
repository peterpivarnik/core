package com.pp.core.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.pp.core.controller.api.CreateService;
import com.pp.core.controller.dependencies.FromCreateDtoMapperProvider;
import com.pp.core.controller.dependencies.ToDtoMapperProvider;
import com.pp.core.controller.mapper.FromDtoMapper;
import com.pp.core.controller.mapper.ToDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic controller interface that provides functionality to create entities
 * and map them between DTOs and domain records.
 *
 * @param <IR>  the input record type that represents the domain entity for creation
 * @param <OR>  the output record type that represents the created domain entity
 * @param <S>   the service type that implements CreateService interface
 * @param <RD>  the response DTO type returned to the client
 * @param <CD>  the create DTO type received from the client
 * @param <TDM> the mapper type that converts output records to response DTOs
 * @param <FDM> the mapper type that converts create DTOs to input records
 */
public interface CreateController<
    CD,
    FDM extends FromDtoMapper<CD, IR>,
    IR extends Record,
    S extends CreateService<IR, OR>,
    OR extends Record,
    TDM extends ToDtoMapper<OR, RD>,
    RD> extends ToDtoMapperProvider<OR, TDM, RD>, FromCreateDtoMapperProvider<CD, FDM, IR> {

    /**
     * Creates a new entity based on the provided DTO data.
     *
     * @param createDto the DTO containing the data for entity creation
     * @return the created entity converted to response DTO
     */
    @PostMapping
    @ResponseStatus(CREATED)
    @ResponseBody
    default RD create(@RequestBody final CD createDto) {
        IR inputRecord = getFromCreateDtoMapper().fromDto(createDto);
        OR outputRecord = getService().create(inputRecord);
        return getToDtoMapper().toDto(outputRecord);
    }

    /**
     * Returns the service instance that provides entity creation functionality.
     *
     * @return the service implementing CreateService interface
     */
    S getService();

    @Override
    FDM getFromCreateDtoMapper();
}
