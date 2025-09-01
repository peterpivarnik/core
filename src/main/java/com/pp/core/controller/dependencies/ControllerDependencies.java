package com.pp.core.controller.dependencies;

import com.pp.core.controller.mapper.FromDtoMapper;
import com.pp.core.controller.mapper.ToDtoMapper;

/**
 * Interface representing a set of dependencies required by controllers
 * for handling domain record and DTO mapping operations.
 *
 * @param <IR>  the input record type representing the domain entity
 * @param <OR>  the output record type representing the domain entity
 * @param <ID>  the input DTO type used in inbound communication
 * @param <OD>  the output DTO type used in outbound communication
 * @param <FDM> the mapper type responsible for converting input DTOs to domain records
 * @param <TDM> the mapper type responsible for converting domain records to output DTOs
 */
public interface ControllerDependencies<
    ID,
    IR extends Record,
    FDM extends FromDtoMapper<ID, IR>,
    OR extends Record,
    TDM extends ToDtoMapper<OR, OD>,
    OD
    > extends FromUpdateDtoMapperProvider<IR, FDM, ID>, ToDtoMapperProvider<OR, TDM, OD> {
}
