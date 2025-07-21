package com.zdk.podelim.internal.domain.entities;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import com.zdk.podelim.internal.domain.entities.exceptions.EntityExceptions;

/**
 * domain entity event Invariant: name != null, name != "" or " " Invariant: expiresAt >= createdAt
 */
public class Event {
  private final UUID id;
  private String name;
  private final ZonedDateTime createdAt;
  private ZonedDateTime expiresAt;

  /**
   * it's minimum possible constructor
   * @param id
   * @param createdAt
   */
  public Event(UUID id, ZonedDateTime createdAt) {
    this.id = Objects.requireNonNull(id);
    this.createdAt = Objects.requireNonNull(createdAt);
  }

  /**
   * @throws IllegalArgumentException if expiresAt before createdAt
   * @param id
   * @param name
   * @param createdAt
   * @param expiresAt
   */
  public Event(UUID id, String name, ZonedDateTime createdAt, ZonedDateTime expiresAt) {
    Objects.requireNonNull(id);
    Objects.requireNonNull(name);
    Objects.requireNonNull(createdAt);
    Objects.requireNonNull(expiresAt);
    if (expiresAt.isBefore(createdAt))
      throw new IllegalArgumentException(EntityExceptions.EVENT_CANNOT_EXPIRES_BEFORE_CREATION);
    if (name.isBlank()) throw new IllegalArgumentException(EntityExceptions.EVENT_NAME_CANNOT_BE_BLANK);
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.expiresAt = expiresAt;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name.isBlank()) throw new IllegalArgumentException(EntityExceptions.EVENT_NAME_CANNOT_BE_BLANK);
    this.name = name;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public ZonedDateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(ZonedDateTime expiresAt) {
    if (expiresAt.isBefore(createdAt)) throw new IllegalArgumentException(EntityExceptions.EVENT_CANNOT_EXPIRES_BEFORE_CREATION);
    this.expiresAt = expiresAt;
  }

  @Override
  public String toString() {
    return "Event [id="
        + id
        + ", name="
        + name
        + ", createdAt="
        + createdAt
        + ", expiresAt="
        + expiresAt
        + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Event event = (Event) obj;
    return Objects.equals(id, event.id);
  }
}
