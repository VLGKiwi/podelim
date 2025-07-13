package com.zdk.podelim.internal.domain.entities;

public class ExpenseConsumer {
  private long participantId;
  private long expenseId;

  /**
   * @throws IllegalArgumentException if participantId or expenseId is negative.
   * @param participantId
   * @param expenseId
   */
  public ExpenseConsumer(long participantId, long expenseId) {
    if (participantId < 0 || expenseId < 0) throw new IllegalArgumentException("IDs must be positive");

    this.participantId = participantId;
    this.expenseId = expenseId;
  }

  public long getParticipantId() {
    return participantId;
  }

  public void setParticipantId(long participantId) {
    if (participantId < 0) throw new IllegalArgumentException("IDs must be positive"); 
    this.participantId = participantId;
  }

  public long getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(long expenseId) {
    if (expenseId < 0) throw new IllegalArgumentException("IDs must be positive"); 
    this.expenseId = expenseId;
  }

  @Override
  public String toString() {
    return "ExpenseConsumer [participantId=" + participantId + ", expenseId=" + expenseId + "]";
  }

  // TODO: create equals and hashCode
}
