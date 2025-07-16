package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.dto.AddExpenseConsumerResponse
import com.zdk.podelim.data.remote.dto.ConsumerDto
import com.zdk.podelim.data.remote.dto.ExpenseDto
import com.zdk.podelim.data.remote.dto.MessageResponse

interface ExpenseRepository {
    // Expenses
    suspend fun addExpense(
        eventId: String, description: String,
        amount: Double, payerId: Int
    ): ExpenseDto

    suspend fun getExpenses(eventId: String): List<ExpenseDto>
    suspend fun getExpense(eventId: String, expenseId: Int): ExpenseDto
    suspend fun updateExpense(
        eventId: String,
        expenseId: Int,
        description: String,
        amount: Double,
        payerId: Int
    ): ExpenseDto

    suspend fun deleteExpense(eventId: String, expenseId: Int)

    //Consumers
    suspend fun getConsumers(eventId: String, expenseId: Int): List<ConsumerDto>
    suspend fun addConsumer(
        eventId: String,
        expenseId: Int,
        participantId: Int
    ): AddExpenseConsumerResponse
    suspend fun updateConsumers(
        eventId: String,
        expenseId: Int,
        participantIds: List<Int>
    ): MessageResponse

    suspend fun deleteConsumer(eventId: String, expenseId: Int, participantId: Int)
}