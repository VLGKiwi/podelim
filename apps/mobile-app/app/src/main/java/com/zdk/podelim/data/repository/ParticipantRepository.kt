package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.dto.ParticipantDto

interface ParticipantRepository{
    suspend fun addParticipant(eventId: String, name: String) : ParticipantDto
    suspend fun getParticipants(eventId: String) : List<ParticipantDto>
    suspend fun getParticipant(eventId: String, participantId: Int) : ParticipantDto
    suspend fun updateParticipant(eventId: String, participantId: Int, name: String) : ParticipantDto
    suspend fun deleteParticipant(eventId: String, participantId: Int)
}