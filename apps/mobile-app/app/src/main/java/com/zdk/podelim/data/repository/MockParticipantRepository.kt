package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.dto.ParticipantDto
import kotlinx.coroutines.delay

class MockParticipantRepository : ParticipantRepository {
    override suspend fun addParticipant(
        eventId: String,
        name: String
    ): ParticipantDto {
        delay(1000)
        return ParticipantDto(id = (100..1000).random(), name = name)
    }

    override suspend fun getParticipants(eventId: String): List<ParticipantDto> {
        delay(1000)
        return listOf(
            ParticipantDto(1, "Илья"),
            ParticipantDto(2, "Тимофей"),
            ParticipantDto(3, "Артем")
        )
    }

    override suspend fun getParticipant(
        eventId: String,
        participantId: Int
    ): ParticipantDto {
        return ParticipantDto(1, "Илья")
    }

    override suspend fun updateParticipant(
        eventId: String,
        participantId: Int,
        name: String
    ): ParticipantDto {
        return ParticipantDto(id = participantId, name = name)
    }

    override suspend fun deleteParticipant(eventId: String, participantId: Int) {
        delay(500)
    }

}