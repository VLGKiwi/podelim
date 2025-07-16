package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.ApiService
import com.zdk.podelim.data.remote.dto.AddExpenseConsumerRequest
import com.zdk.podelim.data.remote.dto.AddExpenseConsumerResponse
import com.zdk.podelim.data.remote.dto.ConsumerDto
import com.zdk.podelim.data.remote.dto.CreateExpenseRequest
import com.zdk.podelim.data.remote.dto.ExpenseDto
import com.zdk.podelim.data.remote.dto.MessageResponse
import com.zdk.podelim.data.remote.dto.UpdateExpenseConsumersRequest
import com.zdk.podelim.data.remote.dto.UpdateExpenseRequest
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ExpenseRepository {
    override suspend fun addExpense(
        eventId: String,
        description: String,
        amount: Double,
        payerId: Int
    ): ExpenseDto {
        val request = CreateExpenseRequest(description, amount, payerId)
        return apiService.addExpense(eventId, request)
    }

    override suspend fun getExpenses(eventId: String): List<ExpenseDto> {
        return apiService.getExpenses(eventId)
    }

    override suspend fun getExpense(
        eventId: String,
        expenseId: Int
    ): ExpenseDto {
        return apiService.getExpense(eventId, expenseId)
    }

    override suspend fun updateExpense(
        eventId: String,
        expenseId: Int,
        description: String,
        amount: Double,
        payerId: Int
    ): ExpenseDto {
        val request = UpdateExpenseRequest(description, amount, payerId)
        return apiService.updateExpense(eventId, expenseId, request)
    }

    override suspend fun deleteExpense(eventId: String, expenseId: Int) {
        apiService.deleteExpense(eventId, expenseId)
    }

    override suspend fun getConsumers(
        eventId: String,
        expenseId: Int
    ): List<ConsumerDto> {
        return apiService.getConsumers(eventId, expenseId).consumers
    }

    override suspend fun addConsumer(
        eventId: String,
        expenseId: Int,
        participantId: Int
    ): AddExpenseConsumerResponse {
        val request = AddExpenseConsumerRequest(participantId)
        return apiService.addConsumer(eventId, expenseId, request)
    }

    override suspend fun updateConsumers(
        eventId: String,
        expenseId: Int,
        participantIds: List<Int>
    ): MessageResponse {
        val request = UpdateExpenseConsumersRequest(participantIds)
        return apiService.updateConsumers(eventId, expenseId, request)
    }

    override suspend fun deleteConsumer(
        eventId: String,
        expenseId: Int,
        participantId: Int
    ) {
        apiService.deleteConsumer(eventId, expenseId, participantId)
    }

}