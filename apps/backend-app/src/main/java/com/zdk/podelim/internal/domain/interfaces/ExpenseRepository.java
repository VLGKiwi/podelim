package com.zdk.podelim.internal.domain.interfaces;

import java.util.List;
import java.util.UUID;

import com.zdk.podelim.internal.domain.entities.Expense;

public interface ExpenseRepository {
    public void save(Expense expense);
    public List<Expense> findAllByEventId(UUID eventId);
    public Expense findById(long expenseId);
    public void updateById(Expense expense, long expenseId);
    public void deleteById(UUID eventId, long expenseId);
}
