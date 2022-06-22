package com.grupoimagen.samplecompose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grupoimagen.samplecompose2.ui.theme.SampleCompose2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageMessageCard()
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Column {
        Text(text = msg.author)
        // Add a vertical space between the author and message texts
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = msg.body)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Colleague", "Hey, take a look at Jetpack Compose")
    )
}

@Preview(showBackground = true)
@Composable
fun ImageMessageCard() {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.login_image),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(80.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(4.dp))

        Column {
            MessageCard(
                msg = Message("Colleague", "Hey, take a look at Jetpack Compose")
            )
        }
    }
}