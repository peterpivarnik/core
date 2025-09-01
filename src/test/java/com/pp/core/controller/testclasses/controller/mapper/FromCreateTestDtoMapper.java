package com.pp.core.controller.testclasses.controller.mapper;

import static org.mapstruct.ReportingPolicy.ERROR;

import com.pp.core.controller.mapper.FromDtoMapper;
import com.pp.core.controller.testclasses.controller.dto.CreateTestDto;
import com.pp.core.controller.testclasses.service.record.InputTestRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR)
public interface FromCreateTestDtoMapper extends FromDtoMapper<CreateTestDto, InputTestRecord> {
}
