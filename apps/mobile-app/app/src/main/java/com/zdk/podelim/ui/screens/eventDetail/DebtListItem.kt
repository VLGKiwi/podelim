package com.zdk.podelim.ui.screens.eventDetail


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zdk.podelim.data.remote.dto.DebtDto
import com.zdk.podelim.data.remote.dto.ParticipantDto
import com.zdk.podelim.ui.theme.PodelimTheme

@Composable
fun DebtListItem(
    debt: DebtDto,
    participants: List<ParticipantDto>,
    modifier: Modifier = Modifier
) {
    val fromName = participants.find { it.id == debt.fromId }?.name ?: "Кто-то"
    val toName = participants.find { it.id == debt.toId }?.name ?: "кому-то"

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = fromName,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "owes to",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = toName,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Text(
                text = "${debt.amount} ₽",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.error,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DebtListItemPreview() {
    PodelimTheme {
        DebtListItem(
            debt = DebtDto(fromId = 2, toId = 1, amount = 750.0),
            participants = listOf(
                ParticipantDto(1, "Илья"),
                ParticipantDto(2, "Тимофей")
            )
        )
    }
}