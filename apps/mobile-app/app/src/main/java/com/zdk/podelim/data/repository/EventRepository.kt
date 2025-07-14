package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.dto.EventCreationResponse
import com.zdk.podelim.data.remote.dto.EventDetailDto
import com.zdk.podelim.data.remote.dto.EventSummaryDto

interface EventRepository {
    suspend fun getEvents() : List<EventSummaryDto>
    suspend fun getEventDetails(eventId: String) : EventDetailDto
    suspend fun createEvent(name: String, date: String) : EventCreationResponse
    suspend fun updateEvent(eventId: String, name: String, date: String) : EventSummaryDto
    suspend fun deleteEvent(eventId: String)
}