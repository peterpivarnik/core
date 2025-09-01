package com.pp.core.controller.testclasses.controller.mapper;

import static org.mapstruct.ReportingPolicy.ERROR;

import com.pp.core.controller.mapper.ToDtoMapper;
import com.pp.core.controller.testclasses.controller.dto.TestDto;
import com.pp.core.controller.testclasses.service.record.OutputTestRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR)
public interface ToTestDtoMapper extends ToDtoMapper<OutputTestRecord, TestDto> {
}
