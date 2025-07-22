package com.zdk.podelim.ui.screens.eventDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zdk.podelim.data.remote.dto.DebtDto
import com.zdk.podelim.data.remote.dto.ExpenseDto
import com.zdk.podelim.data.remote.dto.ParticipantDto
import com.zdk.podelim.data.repository.DebtRepository
import com.zdk.podelim.data.repository.EventRepository
import com.zdk.podelim.data.repository.ExpenseRepository
import com.zdk.podelim.data.repository.ParticipantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class EventDetailUiState(
    val isLoading: Boolean = true,
    val isUpdating: Boolean = false,
    val eventName: String = "",
    val eventDate: String = "",
    val participants: List<ParticipantDto> = emptyList(),
    val expenses: List<ExpenseDto> = emptyList(),
    val debts: List<DebtDto> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class EventDetailViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val participantRepository: ParticipantRepository,
    private val expenseRepository: ExpenseRepository,
    private val debtRepository: DebtRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(EventDetailUiState())
    val uiState = _uiState.asStateFlow()

    val eventId: String = checkNotNull(savedStateHandle.get<String>("eventId"))

    init {
        loadEventDetails()
    }

    fun loadEventDetails() {
        viewModelScope.launch {
            if (_uiState.value.eventName.isEmpty()) {
                _uiState.update { currentState -> currentState.copy(isLoading = true) }
            }

            try {
                val detailsDto = eventRepository.getEventDetails(eventId)

                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        eventName = detailsDto.name,
                        eventDate = detailsDto.date,
                        participants = detailsDto.participants,
                        expenses = detailsDto.expenses,
                        debts = detailsDto.debts,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        error = e.message ?: "An unknown error occurred"
                    )
                }
            }
        }
    }

    fun addParticipant(name: String) {
        viewModelScope.launch {
            _uiState.update { currentState -> currentState.copy(isUpdating = true) }
            try {
                participantRepository.addParticipant(eventId, name)

                loadEventDetails()
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(error = e.message ?: "An unknown error occurred")
                }
            } finally {
                _uiState.update { currentState -> currentState.copy(isUpdating = false) }
            }
        }
    }
}