package com.zdk.podelim.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// GET /api/v1/events/{eventId}/debts
@Serializable
data class DebtDto(
    @SerialName("from")
    val fromId: Int,
    @SerialName("to")
    val toId: Int,
    val amount: Double,
)
