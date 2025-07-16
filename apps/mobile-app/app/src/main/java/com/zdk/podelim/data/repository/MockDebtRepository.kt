package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.dto.DebtDto
import kotlinx.coroutines.delay

class MockDebtRepository : DebtRepository {
    override suspend fun getDebts(eventId: String): List<DebtDto> {
        delay(1000)
        return listOf(
            DebtDto(fromId = 2, toId = 1, amount = 450.0),
            DebtDto(fromId = 3, toId = 1, amount = 150.0),
            DebtDto(fromId = 3, toId = 2, amount = 50.0)
        )
    }
}