package com.example.clickablecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }

        
    }
}

@Composable
fun DataPlanCard(
    dataAmount: String,
    validityDays: String,
    price: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = 3.dp,
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.Red,
                    Color(0xFFFFC0CB), // Pink
                    Color(0xFF800080)  // Purple
                )
            )
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(16.dp)
        ) {
            // Top Start corner
            Text(
                text = dataAmount,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.TopStart)
            )

            // Bottom Start corner
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.AccessTime,
                    contentDescription = "Duration",
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .size(20.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = validityDays,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            // Bottom End corner
            Text(
                text = price,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

data class DataPlan(
    val dataAmount: String,
    val validityDays: String,
    val price: String
)

val plans = listOf(
    DataPlan("30 GB", "30 DAYS", "৳299"),
    DataPlan("15 GB", "15 DAYS", "৳199"),
    DataPlan("5 GB", "7 DAYS", "৳99")
)

@Composable
fun DataPlanList(plans: List<DataPlan>, onPlanClick: (DataPlan) -> Unit) {
    LazyColumn {
        items(plans) { plan ->
            DataPlanCard(
                dataAmount = plan.dataAmount,
                validityDays = plan.validityDays,
                price = plan.price,
                onClick = { onPlanClick(plan) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DataPlanCardListPreview() {
    Column {
        DataPlanCard(
            dataAmount = "30 GB",
            validityDays = "30 DAYS",
            price = "৳299",
            onClick = {}
        )
        DataPlanCard(
            dataAmount = "15 GB",
            validityDays = "15 DAYS",
            price = "৳199",
            onClick = {}
        )
        DataPlanCard(
            dataAmount = "5 GB",
            validityDays = "7 DAYS",
            price = "৳99",
            onClick = {}
        )
    }
}







