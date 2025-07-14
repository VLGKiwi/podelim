package com.zdk.podelim.data.repository

import com.zdk.podelim.data.remote.dto.DebtDto
import com.zdk.podelim.data.remote.dto.EventCreationResponse
import com.zdk.podelim.data.remote.dto.EventDetailDto
import com.zdk.podelim.data.remote.dto.EventSummaryDto
import com.zdk.podelim.data.remote.dto.ExpenseDto
import com.zdk.podelim.data.remote.dto.ParticipantDto
import kotlinx.coroutines.delay

class MockEventRepository : EventRepository {
    override suspend fun getEvents(): List<EventSummaryDto> {
        delay(1000)
        return listOf(
            EventSummaryDto("1", "вечеринка", "2025-07-01"),
            EventSummaryDto("2", "поминки", "2025-10-26"),
            EventSummaryDto("3", "день рождения", "2025-01-11"),
        )
    }

    override suspend fun getEventDetails(eventId: String): EventDetailDto {
        delay(1000)
        return EventDetailDto(
            id = "1",
            name = "вечеринка",
            date = "2025-07-13",
            participants = listOf(
                ParticipantDto(1, "илья"),
                ParticipantDto(2, "тимофей"),
                ParticipantDto(3, "артём"),
            ),
            expenses = listOf(
                ExpenseDto(1, "пиво", 150.0, 1, listOf(1)),
                ExpenseDto(2, "пицца", 600.00, 1, listOf(1, 2))
            ),
            debts = listOf(
                DebtDto(fromId = 2, toId = 1, amount = 300.00)
            )
        )
    }

    override suspend fun createEvent(
        name: String,
        date: String
    ): EventCreationResponse {
        delay(1000)
        return EventCreationResponse(id = "mock-id-${System.currentTimeMillis()}")
    }

    override suspend fun updateEvent(
        eventId: String,
        name: String,
        date: String
    ): EventSummaryDto {
        delay(1000)
        return EventSummaryDto(id = eventId, name = name, date = date)
    }

    override suspend fun deleteEvent(eventId: String) {
        delay(500)
    }
}