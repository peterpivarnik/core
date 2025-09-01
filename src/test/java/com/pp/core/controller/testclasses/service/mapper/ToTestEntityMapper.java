package com.pp.core.controller.testclasses.service.mapper;

import static org.mapstruct.ReportingPolicy.ERROR;

import com.pp.core.controller.testclasses.dao.entity.TestEntity;
import com.pp.core.controller.testclasses.service.record.InputTestRecord;
import com.pp.core.service.mapper.ToEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR)
public interface ToTestEntityMapper extends ToEntityMapper<InputTestRecord, TestEntity> {

  @Override
  @Mapping(target = "id", ignore = true)
  TestEntity toEntity(InputTestRecord record);
}
