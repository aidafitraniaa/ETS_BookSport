package com.example.booksport.ui.screens

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booksport.ui.components.AppBackground
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(navController: NavController) {
    AppBackground {
        val context = LocalContext.current

        var selectedSport by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        var selectedDate by remember { mutableStateOf("") }
        var selectedTime by remember { mutableStateOf("") }
        var userName by remember { mutableStateOf("") }

        val sportOptions = listOf("Futsal", "Badminton", "Basket")
        val calendar = Calendar.getInstance()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Formulir Pemesanan", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Nama Pemesan") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = selectedSport,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Pilih Jenis Olahraga") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    sportOptions.forEach { sport ->
                        DropdownMenuItem(
                            text = { Text(sport) },
                            onClick = {
                                selectedSport = sport
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        DatePickerDialog(
                            context,
                            { _, year, month, dayOfMonth ->
                                selectedDate =
                                    String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth)
                            },
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH)
                        ).show()
                    }
            ) {
                TextField(
                    value = selectedDate,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Tanggal") },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = false
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            TextField(
                value = selectedTime,
                onValueChange = { selectedTime = it },
                label = { Text("Waktu (misal: 14:30)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (userName.isNotBlank() &&
                        selectedSport.isNotBlank() &&
                        selectedDate.isNotBlank() &&
                        selectedTime.isNotBlank()
                    ) {

                        navController.navigate(
                            "confirmation/$userName/$selectedSport/$selectedDate/$selectedTime"
                        )
                    } else {
                        Toast.makeText(context, "Semua field harus diisi", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Kirim Pemesanan")
            }

        }
    }
}
