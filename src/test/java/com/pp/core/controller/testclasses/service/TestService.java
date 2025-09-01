package com.pp.core.controller.testclasses.service;

import com.pp.core.controller.testclasses.dao.entity.TestEntity;
import com.pp.core.controller.testclasses.dao.repository.TestRepository;
import com.pp.core.controller.testclasses.service.mapper.FromTestEntityMapper;
import com.pp.core.controller.testclasses.service.mapper.ToTestEntityMapper;
import com.pp.core.controller.testclasses.service.record.InputTestRecord;
import com.pp.core.controller.testclasses.service.record.OutputTestRecord;
import com.pp.core.service.DefaultCreateService;
import com.pp.core.service.DefaultDeleteService;
import com.pp.core.service.DefaultGetByIdService;
import com.pp.core.service.DefaultUpdateService;
import org.springframework.stereotype.Service;

@Service
public class TestService
    implements
    DefaultCreateService<InputTestRecord, ToTestEntityMapper, Long, TestEntity, TestRepository, FromTestEntityMapper, OutputTestRecord>,
    DefaultDeleteService<Long, TestEntity, TestRepository>,
    DefaultUpdateService<Long, InputTestRecord, TestEntity, TestRepository, FromTestEntityMapper, OutputTestRecord>,
    DefaultGetByIdService<Long, TestEntity, TestRepository, FromTestEntityMapper, OutputTestRecord> {

  private final TestRepository testRepository;
  private final ToTestEntityMapper toTestEntityMapper;
  private final FromTestEntityMapper fromTestEntityMapper;

  public TestService(TestRepository testRepository,
                     ToTestEntityMapper toTestEntityMapper,
                     FromTestEntityMapper fromTestEntityMapper) {
    this.testRepository = testRepository;
    this.toTestEntityMapper = toTestEntityMapper;
    this.fromTestEntityMapper = fromTestEntityMapper;
  }

  @Override
  public FromTestEntityMapper getFromEntityMapper() {
    return fromTestEntityMapper;
  }

  @Override
  public TestRepository getRepository() {
    return testRepository;
  }

  @Override
  public ToTestEntityMapper getToEntityMapper() {
    return toTestEntityMapper;
  }

  @Override
  public TestEntity updateEntity(TestEntity entity, InputTestRecord record) {
    entity.setName(record.name());
    return entity;
  }
}
