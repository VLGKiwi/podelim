package com.zdk.podelim.data.remote

import com.zdk.podelim.data.remote.dto.AddExpenseConsumerRequest
import com.zdk.podelim.data.remote.dto.AddExpenseConsumerResponse
import com.zdk.podelim.data.remote.dto.AddParticipantRequest
import com.zdk.podelim.data.remote.dto.CreateEventRequest
import com.zdk.podelim.data.remote.dto.CreateExpenseRequest
import com.zdk.podelim.data.remote.dto.DebtDto
import com.zdk.podelim.data.remote.dto.EventCreationResponse
import com.zdk.podelim.data.remote.dto.EventDetailDto
import com.zdk.podelim.data.remote.dto.EventSummaryDto
import com.zdk.podelim.data.remote.dto.ExpenseConsumersResponse
import com.zdk.podelim.data.remote.dto.ExpenseDto
import com.zdk.podelim.data.remote.dto.MessageResponse
import com.zdk.podelim.data.remote.dto.ParticipantDto
import com.zdk.podelim.data.remote.dto.UpdateEventRequest
import com.zdk.podelim.data.remote.dto.UpdateExpenseConsumersRequest
import com.zdk.podelim.data.remote.dto.UpdateExpenseRequest
import com.zdk.podelim.data.remote.dto.UpdateParticipantRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    // Events
    @POST("api/events")
    suspend fun createEvent(@Body request: CreateEventRequest): EventCreationResponse

    @GET("api/events")
    suspend fun getAllEvents(): List<EventSummaryDto>

    @GET("api/events/{eventId}")
    suspend fun getEventDetails(@Path("eventId") eventId: String): EventDetailDto

    @PUT("api/events/{eventId}")
    suspend fun updateEvent(
        @Path("eventId") eventId: String,
        @Body request: UpdateEventRequest
    ): EventSummaryDto

    @DELETE("api/events/{eventId}")
    suspend fun deleteEvent(@Path("eventId") eventId: String)

    //Participants
    @POST("api/events/{eventId}/participants")
    suspend fun addParticipant(
        @Path("eventId") eventId: String,
        @Body request: AddParticipantRequest
    ): ParticipantDto

    @GET("api/events/{eventId}/participants")
    suspend fun getParticipants(@Path("eventId") eventId: String): List<ParticipantDto>

    @GET("api/events/{eventId}/participants/{participantId}")
    suspend fun getParticipant(
        @Path("eventId") eventId: String,
        @Path("participantId") participantId: Int
    ): ParticipantDto

    @PUT("api/events/{eventId}/participants/{participantId}")
    suspend fun updateParticipant(
        @Path("eventId") eventId: String,
        @Path("participantId") participantId: Int,
        @Body request: UpdateParticipantRequest
    ): ParticipantDto

    @DELETE("api/events/{eventId}/participants/{participantId}")
    suspend fun deleteParticipant(
        @Path("eventId") eventId: String,
        @Path("participantId") participantId: Int
    )

    //Expenses
    @POST("api/events/{eventId}/expenses")
    suspend fun addExpense(
        @Path("eventId") eventId: String,
        @Body request: CreateExpenseRequest
    ): ExpenseDto

    @GET("api/events/{eventId}/expenses")
    suspend fun getExpenses(@Path("eventId") eventId: String): List<ExpenseDto>

    @GET("api/events/{eventId}/expenses/{expenseId}")
    suspend fun getExpense(
        @Path("eventId") eventId: String,
        @Path("expenseId") expenseId: Int
    ): ExpenseDto

    @PUT("api/events/{eventId}/expenses/{expenseId}")
    suspend fun updateExpense(
        @Path("eventId") eventId: String,
        @Path("expenseId") expenseId: Int,
        @Body request: UpdateExpenseRequest
    ): ExpenseDto

    @DELETE("api/events/{eventId}/expenses/{expenseId}")
    suspend fun deleteExpense(@Path("eventId") eventId: String, @Path("expenseId") expenseId: Int)

    //Expense Consumers
    @GET("api/events/{eventId}/expenses/{expenseId}/consumers")
    suspend fun getConsumers(
        @Path("eventId") eventId: String,
        @Path("expenseId") expenseId: Int
    ): ExpenseConsumersResponse

    @POST("api/events/{eventId}/expenses/{expenseId}/consumers")
    suspend fun addConsumer(
        @Path("eventId") eventId: String,
        @Path("expenseId") expenseId: Int,
        @Body request: AddExpenseConsumerRequest
    ): AddExpenseConsumerResponse

    @PUT("api/events/{eventId}/expenses/{expenseId}/consumers")
    suspend fun updateConsumers(
        @Path("eventId") eventId: String,
        @Path("expenseId") expenseId: Int,
        @Body request: UpdateExpenseConsumersRequest
    ): MessageResponse

    @DELETE("api/events/{eventId}/expenses/{expenseId}/consumers/{participantId}")
    suspend fun deleteConsumer(
        @Path("eventId") eventId: String,
        @Path("expenseId") expenseId: Int,
        @Path("participantId") participantId: Int
    )

    //Debts
    @GET("api/events/{eventId}/debts")
    suspend fun getDebts(@Path("eventId") eventId: String): List<DebtDto>

}