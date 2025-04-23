package com.example.booksport.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booksport.model.SportVenue
import com.example.booksport.navigation.Routes
import com.example.booksport.R

@Composable
fun VenueListScreen(navController: NavController) {
    val venues = listOf(
        SportVenue(1, "Lapangan A", "Futsal", R.drawable.lapangan_futsal),
        SportVenue(2, "Lapangan B", "Badminton", R.drawable.lapangan_badminton),
        SportVenue(3, "Lapangan C", "Basket", R.drawable.lapangan_basket)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Daftar Tempat Olahraga",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(venues) { venue ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = painterResource(id = venue.imageResId),
                            contentDescription = venue.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .clip(MaterialTheme.shapes.medium)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = venue.name,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = venue.sportType,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(Routes.BOOKING)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .shadow(6.dp, shape = MaterialTheme.shapes.large),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = MaterialTheme.shapes.large
        ) {
            Text("Pesan Sekarang", style = MaterialTheme.typography.titleMedium)
        }
    }
}
