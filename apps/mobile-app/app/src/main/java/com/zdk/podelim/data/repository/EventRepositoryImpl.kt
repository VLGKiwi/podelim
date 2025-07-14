package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.ApiService
import com.zdk.podelim.data.remote.dto.CreateEventRequest
import com.zdk.podelim.data.remote.dto.EventCreationResponse
import com.zdk.podelim.data.remote.dto.EventDetailDto
import com.zdk.podelim.data.remote.dto.EventSummaryDto
import com.zdk.podelim.data.remote.dto.UpdateEventRequest
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : EventRepository {
    override suspend fun getEvents(): List<EventSummaryDto> {
       return apiService.getAllEvents()
    }

    override suspend fun getEventDetails(eventId: String): EventDetailDto {
        return apiService.getEventDetails(eventId)
    }

    override suspend fun createEvent(
        name: String,
        date: String
    ): EventCreationResponse {
        val request = CreateEventRequest(name, date)
        return apiService.createEvent(request)
    }

    override suspend fun updateEvent(
        eventId: String,
        name: String,
        date: String
    ): EventSummaryDto {
        val request = UpdateEventRequest(name, date)
        return apiService.updateEvent(eventId, request)
    }

    override suspend fun deleteEvent(eventId: String) {
        apiService.deleteEvent(eventId)
    }

}