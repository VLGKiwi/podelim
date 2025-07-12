package com.zdk.podelim.data.remote.dto

import kotlinx.serialization.Serializable

// GET /api/events/{eventId}/debts
@Serializable
data class DebtDto(
    val from: Int,
    val to: Int,
    val amount: Double,
)
