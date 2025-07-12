package com.zdk.podelim.data.remote.dto

import kotlinx.serialization.Serializable

// Used for responses in GET, POST, PUT expense requests
@Serializable
data class ExpenseDto(
    val id: Int,
    val description: String,
    val amount: Double,
    val payerId: Int,
    val consumerIds: List<Int>,
)

// POST /api/events/{eventId}/expenses
@Serializable
data class CreateExpenseRequest(
    val description: String,
    val amount: Double,
    val payerId: Int,
)

// PUT /api/events/{eventId}/expenses/{expenseId}
@Serializable
data class UpdateExpenseRequest(
    val description: String,
    val amount: Double,
    val payerId: Int,
)

// PUT /api/events/{eventId}/expenses/{expenseId}/consumers
@Serializable
data class UpdateExpenseConsumersRequest(
    val participantIds: List<Int>,
)