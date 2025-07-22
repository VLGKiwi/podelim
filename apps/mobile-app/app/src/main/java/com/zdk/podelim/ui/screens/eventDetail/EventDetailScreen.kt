package com.zdk.podelim.ui.screens.eventDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.lazy.items


@Composable
fun EventDetailScreen() {
    val viewModel: EventDetailViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    EventDetailContent(uiState)

}

@Composable
private fun EventDetailContent(uiState: EventDetailUiState) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when {
                uiState.isLoading -> CircularProgressIndicator()
                uiState.error != null -> Text(text = "Error: ${uiState.error}")
                else -> {
                    // Используем LazyColumn как ОСНОВНОЙ контейнер. Column не нужен.
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // --- Секция 1: Название и дата ---
                        item {
                            Column {
                                Text(
                                    text = uiState.eventName,
                                    style = MaterialTheme.typography.headlineMedium
                                )
                                Text(
                                    text = uiState.eventDate,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }

                        item {
                            Text(
                                text = "Участники",
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                        items(
                            items = uiState.participants,
                            key = { participant -> "participant_${participant.id}" }
                        ) { participant ->
                            ParticipantListItem(
                                participant = participant,
                                onClick = { /* TODO */ }
                            )
                        }

                        item {
                            Text(
                                text = "Траты",
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                        items(
                            items = uiState.expenses,
                            key = { expense -> "expense_${expense.id}" }
                        ) { expense ->
                            ExpenseListItem(
                                expense = expense,
                                participants = uiState.participants,
                                onClick = { /* TODO */ }
                            )
                        }

                        item {
                            Text(
                                text = "Долги",
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                        items(
                            items = uiState.debts,
                            key = { debt -> "debt_${debt.fromId}_${debt.toId}" }
                        ) { debt ->
                            DebtListItem(
                                debt = debt,
                                participants = uiState.participants,
                            )
                        }
                    }
                }
            }
        }
    }
}