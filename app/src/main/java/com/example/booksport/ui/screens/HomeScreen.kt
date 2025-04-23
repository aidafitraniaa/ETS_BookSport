package com.example.booksport.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booksport.navigation.Routes
import com.example.booksport.ui.components.AppBackground

@Composable
fun HomeScreen(navController: NavController) {
    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(
                text = "Selamat datang di BookSport !",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { navController.navigate(Routes.VENUE_LIST) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = MaterialTheme.shapes.large,
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Text(
                        "Lihat Daftar Venue",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Button(
                    onClick = { navController.navigate(Routes.BOOKING) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = MaterialTheme.shapes.large,
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Text(
                        "Buat Pemesanan Baru",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}