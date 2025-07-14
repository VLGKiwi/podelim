package com.zdk.podelim.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// POST /api/events
@Serializable
data class CreateEventRequest(
    val name: String,
    val date: String,
)

// POST /api/events
@Serializable
data class EventCreationResponse(
    @SerialName("eventId")
    val id: String,
)

// Represents a single event in the list from GET /api/events
// Also used as a response for PUT /api/events/{eventId}
@Serializable
data class EventSummaryDto(
    @SerialName("eventId")
    val id: String,
    val name: String,
    val date: String,
)

// GET /api/events/{eventId}
@Serializable
data class EventDetailDto(
    @SerialName("eventId")
    val id: String,
    val name: String,
    val date: String,
    val participants: List<ParticipantDto>,
    val expenses: List<ExpenseDto>,
    val debts: List<DebtDto>,
)

//  PUT /api/events/{eventId}
@Serializable
data class UpdateEventRequest(
    val name: String,
    val date: String,
)
