package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.ApiService
import com.zdk.podelim.data.remote.dto.DebtDto
import javax.inject.Inject

class DebtRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : DebtRepository {
    override suspend fun getDebts(eventId: String): List<DebtDto> {
        return apiService.getDebts(eventId)
    }
}