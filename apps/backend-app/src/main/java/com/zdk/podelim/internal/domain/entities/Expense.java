package com.zdk.podelim.internal.domain.entities;

import java.util.Objects;
import java.util.UUID;

/**
 * domain entity of expense
 *
 * <p>Invariant: amount >= 0
 */
public class Expense {
  private final long id;
  private long payerId;
  private final UUID eventId;
  private String description;

  /** amount field can't be less than 0 */
  private int amount;

  public Expense(long id, long payerId, UUID eventId, String description, int amount) {
    Objects.requireNonNull(id);
    Objects.requireNonNull(eventId);
    Objects.requireNonNull(amount);
    if (amount < 0) throw new IllegalArgumentException("amount can't be less than 0");

    this.id = id;
    this.payerId = payerId;
    this.eventId = eventId;
    this.description = description;
    this.amount = amount;
  }

  public long getId() {
    return id;
  }

  public long getPayerId() {
    return payerId;
  }

  public void setPayerId(long payerId) {
    this.payerId = payerId;
  }

  public UUID getEventId() {
    return eventId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Expense [id="
        + id
        + ", payerId="
        + payerId
        + ", eventId="
        + eventId
        + ", description="
        + description
        + ", amount="
        + amount
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
    Expense expense = (Expense) obj;
    return Objects.equals(id, expense.id);
  }
}
