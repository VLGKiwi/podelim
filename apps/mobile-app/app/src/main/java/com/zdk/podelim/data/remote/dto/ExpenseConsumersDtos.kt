package com.zdk.podelim.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// GET /api/events/{eventId}/expenses/{expenseId}/consumers
@Serializable
data class ExpenseConsumersResponse(
    @SerialName("expenseId")
    val expenseId: Int,
    val consumers: List<ConsumerDto>,
)

// Represents a single consumer
@Serializable
data class ConsumerDto(
    @SerialName("participantId")
    val id: Int,
    val name: String,
)

// POST /api/events/{eventId}/expenses/{expenseId}/consumers
@Serializable
data class AddExpenseConsumerRequest(
    @SerialName("participantId")
    val participantId: Int,
)

// PUT /api/events/{eventId}/expenses/{expenseId}/consumers
@Serializable
data class UpdateExpenseConsumersRequest(
    @SerialName("participantIds")
    val participantIds: List<Int>,
)

// POST /api/events/{eventId}/expenses/{expenseId}/consumers
@Serializable
data class AddExpenseConsumerResponse(
    @SerialName("expenseId")
    val expenseId: Int,
    @SerialName("participantId")
    val participantId: Int,
    val message: String,
)