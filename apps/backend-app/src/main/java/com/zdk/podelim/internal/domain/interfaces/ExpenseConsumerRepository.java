package com.zdk.podelim.internal.domain.interfaces;

import java.util.List;
import java.util.UUID;

import com.zdk.podelim.internal.domain.entities.Participant;

// TODO: переписать методы, когда подниму базу данных
public interface ExpenseConsumerRepository {
    public List<Participant> allConsumers(UUID eventId, long expenseId);
    public void saveConsumer(UUID eventId, long expenseId);
    public void deleteConsumer(UUID eventId, long expenseId, UUID participantId);
}
