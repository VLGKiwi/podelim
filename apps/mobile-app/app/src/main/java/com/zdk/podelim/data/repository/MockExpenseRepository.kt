package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.dto.AddExpenseConsumerResponse
import com.zdk.podelim.data.remote.dto.ConsumerDto
import com.zdk.podelim.data.remote.dto.ExpenseDto
import com.zdk.podelim.data.remote.dto.MessageResponse
import kotlinx.coroutines.delay

class MockExpenseRepository : ExpenseRepository {

    override suspend fun addExpense(
        eventId: String,
        description: String,
        amount: Double,
        payerId: Int
    ): ExpenseDto {
        delay(1000)
        return ExpenseDto(
            id = (100..1000).random(),
            description = description,
            amount = amount,
            payerId = payerId,
            consumerIds = listOf(payerId)
        )
    }

    override suspend fun getExpenses(eventId: String): List<ExpenseDto> {
        delay(1000)
        return listOf(
            ExpenseDto(1, "Пицца", 1200.0, 1, listOf(1, 2)),
            ExpenseDto(2, "Такси", 450.5, 2, listOf(1, 2, 3)),
            ExpenseDto(3, "Билеты в кино", 900.0, 3, listOf(3))
        )
    }

    override suspend fun getExpense(
        eventId: String,
        expenseId: Int
    ): ExpenseDto {
        delay(1000)
        return ExpenseDto(expenseId, "Пицца", 1200.0, 1, listOf(1, 2))
    }

    override suspend fun updateExpense(
        eventId: String,
        expenseId: Int,
        description: String,
        amount: Double,
        payerId: Int
    ): ExpenseDto {
        delay(1000)

        return ExpenseDto(expenseId, description, amount, payerId, listOf(payerId))
    }

    override suspend fun deleteExpense(eventId: String, expenseId: Int) {
        delay(500)
    }


    override suspend fun getConsumers(
        eventId: String,
        expenseId: Int
    ): List<ConsumerDto> {
        delay(1000)
        return listOf(
            ConsumerDto(1, "Илья"),
            ConsumerDto(2, "Тимофей")
        )
    }

    override suspend fun addConsumer(
        eventId: String,
        expenseId: Int,
        participantId: Int
    ): AddExpenseConsumerResponse {
        delay(1000)
        return AddExpenseConsumerResponse(
            expenseId = expenseId,
            participantId = participantId,
            message = "Consumer added successfully (mock)"
        )
    }

    override suspend fun updateConsumers(
        eventId: String,
        expenseId: Int,
        participantIds: List<Int>
    ): MessageResponse {
        delay(1000)
        return MessageResponse("Consumers list updated successfully (mock)")
    }

    override suspend fun deleteConsumer(
        eventId: String,
        expenseId: Int,
        participantId: Int
    ) {
        delay(500)
    }
}