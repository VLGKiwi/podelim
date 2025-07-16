package com.zdk.podelim.ui.screens.eventList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zdk.podelim.data.remote.dto.EventSummaryDto

@Composable
fun EventListScreen(
    onEventClick: (String) -> Unit
) {
    val viewModel: EventListViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadEvents()
    }

    Scaffold { innerPadding ->
        EventListContent(
            uiState = uiState,
            modifier = Modifier.padding(innerPadding),
            onEventClick = onEventClick
        )
    }
}

@Composable
private fun EventListContent(
    uiState: EventListUiState,
    onEventClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        when {
            uiState.isLoading -> {
                LoadingState(modifier = Modifier.align(Alignment.Center))
            }

            uiState.error != null -> {
                ErrorState(
                    message = uiState.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                EventList(
                    events = uiState.events,
                    onEventClick = onEventClick
                )
            }
        }
    }
}

@Composable
private fun EventList(
    events: List<EventSummaryDto>,
    onEventClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(
            items = events,
            key = { event -> event.id }
        ) { event ->
            EventListItem(
                eventSummaryDto = event,
                onClick = { onEventClick(event.id) }
            )
        }
    }
}

@Composable
private fun LoadingState(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier)
}

@Composable
private fun ErrorState(message: String, modifier: Modifier = Modifier) {
    Text(
        text = "Error: $message",
        modifier = modifier
    )
}