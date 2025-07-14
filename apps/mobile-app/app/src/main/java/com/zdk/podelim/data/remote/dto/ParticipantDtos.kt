package com.zdk.podelim.data.remote.dto

import kotlinx.serialization.Serializable

/// Used in GET /api/events/{eventId}/participants
// and as a response for POST and PUT participant requests
@Serializable
data class ParticipantDto(
    val id: Int,
    val name: String,
)

// POST /api/events/{eventId}/participants
@Serializable
data class AddParticipantRequest(
    val name: String,
)

// PUT /api/events/{eventId}/participants/{participantId}
@Serializable
data class UpdateParticipantRequest(
    val name: String,
)

