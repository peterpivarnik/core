package com.pp.core.controller.testclasses.service.mapper;

import static org.mapstruct.ReportingPolicy.ERROR;

import com.pp.core.controller.testclasses.dao.entity.TestEntity;
import com.pp.core.controller.testclasses.service.record.OutputTestRecord;
import org.mapstruct.Mapper;
import com.pp.core.service.mapper.FromEntityMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR)
public interface FromTestEntityMapper extends FromEntityMapper<TestEntity, OutputTestRecord> {
}
