package com.zdk.podelim.internal.domain.entities;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import com.zdk.podelim.internal.domain.entities.exceptions.EntityExceptions;

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
  private BigDecimal amount;

  public Expense(long id, long payerId, UUID eventId, String description, BigDecimal amount) {
    Objects.requireNonNull(id);
    Objects.requireNonNull(eventId);
    Objects.requireNonNull(amount);
    if (amount.compareTo(new BigDecimal(0)) == -1)
      throw new IllegalArgumentException(EntityExceptions.EXPENSE_AMOUNT_CANNOT_BE_NEGATIVE);

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

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    if (amount.compareTo(new BigDecimal(0)) == -1)
      throw new IllegalArgumentException(EntityExceptions.EXPENSE_AMOUNT_CANNOT_BE_NEGATIVE);
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
