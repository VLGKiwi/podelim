package com.zdk.podelim.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Used for responses in GET, POST, and PUT expense requests
@Serializable
data class ExpenseDto(
    val id: Int,
    val description: String,
    val amount: Double,
    @SerialName("payerId")
    val payerId: Int,
    @SerialName("consumerIds")
    val consumerIds: List<Int>,
)

// POST /api/events/{eventId}/expenses
@Serializable
data class CreateExpenseRequest(
    val description: String,
    val amount: Double,
    @SerialName("payerId")
    val payerId: Int,
)

// PUT /api/events/{eventId}/expenses/{expenseId}
@Serializable
data class UpdateExpenseRequest(
    val description: String,
    val amount: Double,
    @SerialName("payerId")
    val payerId: Int,
)