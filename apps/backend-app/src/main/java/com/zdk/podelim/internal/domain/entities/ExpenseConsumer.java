package com.zdk.podelim.internal.domain.entities;

import java.util.Objects;

public class ExpenseConsumer {
    private long participantId;
    private long expenseId;

    public ExpenseConsumer(long participantId, long expenseId) {
        Objects.requireNonNull(participantId);
        Objects.requireNonNull(expenseId);
        
        this.participantId = participantId;
        this.expenseId = expenseId;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(long expenseId) {
        this.expenseId = expenseId;
    }

    @Override
    public String toString() {
        return "ExpenseConsumer [participantId=" + participantId + ", expenseId=" + expenseId + "]";
    }

    
}
