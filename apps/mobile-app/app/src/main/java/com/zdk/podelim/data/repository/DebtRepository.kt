package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.dto.DebtDto

interface DebtRepository {
    suspend fun getDebts(eventId: String): List<DebtDto>
}