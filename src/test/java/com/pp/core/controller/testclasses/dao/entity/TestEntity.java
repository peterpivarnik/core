package com.pp.core.controller.testclasses.dao.entity;

import com.pp.core.dao.entity.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class TestEntity extends BaseEntity<Long> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
