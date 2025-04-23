package com.example.booksport.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.booksport.navigation.Routes
import com.example.booksport.ui.components.AppBackground

@Composable
fun ConfirmationScreen(navController: NavController, backStackEntry: NavBackStackEntry) {
    AppBackground {
        val userName = backStackEntry.arguments?.getString("userName") ?: "N/A"
        val selectedSport = backStackEntry.arguments?.getString("selectedSport") ?: "N/A"
        val selectedDate = backStackEntry.arguments?.getString("selectedDate") ?: "N/A"
        val selectedTime = backStackEntry.arguments?.getString("selectedTime") ?: "N/A"

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 32.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "Pemesanan Berhasil",
                    modifier = Modifier.size(50.dp),

                    tint = MaterialTheme.colorScheme.primaryContainer
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Pemesanan Berhasil!",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.surfaceVariant,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(20.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    InfoRow("Nama", userName)
                    Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                    InfoRow("Olahraga", selectedSport)
                    Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                    InfoRow("Tanggal", selectedDate)
                    Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                    InfoRow("Waktu", selectedTime)
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { navController.navigate(Routes.HOME) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = MaterialTheme.shapes.large
            ) {
                Text("Kembali ke Home", style = MaterialTheme.typography.titleMedium)
            }

        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun PreviewConfirmationScreen() {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntry!!
    ConfirmationScreen(navController = navController, backStackEntry = backStackEntry)
}