package com.example.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun MyNetworkImage() {
    AsyncImage(
        model = "https://avatars.githubusercontent.com/u/16361358?v=4",
        contentDescription = "Image from network",
        modifier = Modifier.size(250.dp),
        onError = {
            Log.i("Image", "Ha ocurrido un error ${it.result.throwable.message}")
        }
    )
}