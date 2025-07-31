package com.quantumy.bibliotecafreelance.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun CardMenu (
    title: String? = null,
    description: String? = null,
    icon: ImageVector? = null,
){
    Card (
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}