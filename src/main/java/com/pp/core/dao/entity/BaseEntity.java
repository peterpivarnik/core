package com.pp.core.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * An abstract base class for entities, intended to be extended by specific entity classes. This class
 * provides a common structure for entity primary key management using an identifier field annotated
 * as a database ID.
 *
 * @param <I> the type of the identifier, which must be serializable
 */
@MappedSuperclass
public abstract class BaseEntity<I extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private I id;

    public I getId() {
        return id;
    }

    public void setId(final I id) {
        this.id = id;
    }
}
