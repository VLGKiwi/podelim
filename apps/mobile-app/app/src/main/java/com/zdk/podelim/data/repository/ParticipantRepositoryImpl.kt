package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.ApiService
import com.zdk.podelim.data.remote.dto.AddParticipantRequest
import com.zdk.podelim.data.remote.dto.ParticipantDto
import com.zdk.podelim.data.remote.dto.UpdateParticipantRequest
import javax.inject.Inject

class ParticipantRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ParticipantRepository {
    override suspend fun addParticipant(
        eventId: String,
        name: String
    ): ParticipantDto {
        val request = AddParticipantRequest(name)
        return apiService.addParticipant(eventId, request)
    }

    override suspend fun getParticipants(eventId: String): List<ParticipantDto> {
        return apiService.getParticipants(eventId)
    }

    override suspend fun getParticipant(
        eventId: String,
        participantId: Int
    ): ParticipantDto {
        return apiService.getParticipant(eventId, participantId)
    }

    override suspend fun updateParticipant(
        eventId: String,
        participantId: Int,
        name: String
    ): ParticipantDto {
        val request = UpdateParticipantRequest(name)
        return apiService.updateParticipant(eventId, participantId, request)
    }

    override suspend fun deleteParticipant(eventId: String, participantId: Int) {
        apiService.deleteParticipant(eventId, participantId)
    }

}