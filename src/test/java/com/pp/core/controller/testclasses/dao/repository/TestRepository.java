package com.pp.core.controller.testclasses.dao.repository;

import com.pp.core.controller.testclasses.dao.entity.TestEntity;
import com.pp.core.dao.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends BaseRepository<Long, TestEntity> {
}
