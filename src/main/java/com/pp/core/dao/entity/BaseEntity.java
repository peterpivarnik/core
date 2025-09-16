package com.pp.core.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Abstract base class for entities with a generic identifier.
 * This class is designed to be extended by all entity classes, enforcing
 * a standardized approach to handling entity identifiers. The identifier type `I`
 * must implement the `Serializable` interface.
 * The `BaseEntity` class defines a primary key field named `id`, which is annotated
 * with JPA annotations to configure its behavior as an auto-generated identity column.
 *
 * @param <I> the type of the identifier, which must be serializable
 */
@MappedSuperclass
public abstract class BaseEntity<I extends Serializable> {


  /**
   * Default constructor for the BaseEntity class.
   * Required by JPA for entity instantiation and deserialization.
   */
  public BaseEntity() {
  }

  /**
   * The unique identifier for the entity.
   * Annotated with:
   * - @Id to mark it as the primary key
   * - @GeneratedValue to configure auto-generation strategy
   * - @Column to specify the database column name
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private I id;

  /**
   * Returns the unique identifier of this entity.
   *
   * @return the entity's identifier
   */
  public I getId() {
    return id;
  }

  /**
   * Sets the unique identifier for this entity.
   *
   * @param id the identifier to set
   */
  public void setId(final I id) {
    this.id = id;
  }
}
