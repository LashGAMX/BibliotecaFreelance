package com.quantumy.bibliotecafreelance.core.components

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.quantumy.bibliotecafreelance.R

@Composable
@Preview
fun CardResouce (
    id: Int? = null,
    title: String? = "Sin titulo",
    description: String? = "Sin descripcion",
    imageResId: String? = null,
    driveUrl: String? = null, // <-- URL de Google Drive
    navController: NavController? = null,
){
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        onClick = {
            driveUrl?.let {
                // Navega a la pantalla de preview
                navController?.navigate("drivePreview?url=$it")
            } ?: run {
                Toast.makeText(context, "Sin función", Toast.LENGTH_SHORT).show()
            }
        }
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier.size(200.dp),
                model = imageResId,
                contentDescription = "Imagen"
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = title ?: "Sin título")
                Text(text = description ?: "Sin descripción")
            }
        }
    }
}
