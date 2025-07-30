package com.example.userform

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserFormScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var hobbies by remember { mutableStateOf("") }
    var profileImageUrl by remember { mutableStateOf("https://via.placeholder.com/150") }
    var isFormVisible by remember { mutableStateOf(false) }
    var showSuccessMessage by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isFormVisible = true
    }

    val buttonScale by animateFloatAsState(
        targetValue = if (showSuccessMessage) 1.1f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = isFormVisible,
            enter = slideInVertically(
                initialOffsetY = { -40 },
                animationSpec = tween(600)
            ) + fadeIn(animationSpec = tween(600))
        ) {
            Text(
                text = stringResource(R.string.user_profile),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )
        }

        AnimatedVisibility(
            visible = isFormVisible,
            enter = slideInVertically(
                initialOffsetY = { 40 },
                animationSpec = tween(800)
            ) + fadeIn(animationSpec = tween(800))
        ) {
            ProfileImageSection(
                imageUrl = profileImageUrl,
                onImageUrlChange = { profileImageUrl = it }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        AnimatedVisibility(
            visible = isFormVisible,
            enter = slideInVertically(
                initialOffsetY = { 60 },
                animationSpec = tween(1000)
            ) + fadeIn(animationSpec = tween(1000))
        ) {
            FormFields(
                name = name,
                email = email,
                hobbies = hobbies,
                onNameChange = { name = it },
                onEmailChange = { email = it },
                onHobbiesChange = { hobbies = it }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        AnimatedVisibility(
            visible = isFormVisible,
            enter = slideInVertically(
                initialOffsetY = { 80 },
                animationSpec = tween(1200)
            ) + fadeIn(animationSpec = tween(1200))
        ) {
            Button(
                onClick = {
                    showSuccessMessage = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .scale(buttonScale),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = stringResource(R.string.save_button),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        AnimatedVisibility(
            visible = showSuccessMessage,
            enter = fadeIn(animationSpec = tween(500)),
            exit = fadeOut(animationSpec = tween(500))
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = "¡Datos guardados exitosamente!",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun ProfileImageSection(
    imageUrl: String,
    onImageUrlChange: (String) -> Unit
) {
    var showUrlDialog by remember { mutableStateOf(false) }
    var tempUrl by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .clickable { showUrlDialog = true },
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                fallback = {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Foto por defecto",
                        modifier = Modifier.size(60.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            )
        }

        Text(
            text = "Toca para cambiar foto",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(top = 8.dp)
        )
    }

    if (showUrlDialog) {
        AlertDialog(
            onDismissRequest = { showUrlDialog = false },
            title = { Text("URL de la imagen") },
            text = {
                OutlinedTextField(
                    value = tempUrl,
                    onValueChange = { tempUrl = it },
                    label = { Text("Ingresa la URL") },
                    placeholder = { Text("https://ejemplo.com/imagen.jpg") }
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (tempUrl.isNotBlank()) {
                            onImageUrlChange(tempUrl)
                        }
                        showUrlDialog = false
                        tempUrl = ""
                    }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { 
                    showUrlDialog = false
                    tempUrl = ""
                }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormFields(
    name: String,
    email: String,
    hobbies: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onHobbiesChange: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text(stringResource(R.string.name_label)) },
            placeholder = { Text(stringResource(R.string.name_hint)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text(stringResource(R.string.email_label)) },
            placeholder = { Text(stringResource(R.string.email_hint)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = hobbies,
            onValueChange = onHobbiesChange,
            label = { Text(stringResource(R.string.hobbies_label)) },
            placeholder = { Text(stringResource(R.string.hobbies_hint)) },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3,
            maxLines = 5
        )
    }
}