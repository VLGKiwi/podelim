package com.zdk.podelim.ui.screens.eventList


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zdk.podelim.data.remote.dto.EventSummaryDto
import com.zdk.podelim.data.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class EventListUiState(
    val isLoading: Boolean = false,
    val events: List<EventSummaryDto> = emptyList(),
    val error: String? = null,
)

@HiltViewModel
class EventListViewModel @Inject constructor(
    private val eventRepository: EventRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(EventListUiState())
    val uiState = _uiState.asStateFlow()

    fun loadEvents() {
        viewModelScope.launch {
            _uiState.update { currentState -> currentState.copy(isLoading = true) }

            try {
                val loadedEvents = eventRepository.getEvents()
                _uiState.update { currentState ->
                    currentState.copy(isLoading = false, events = loadedEvents, error = null)
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
}