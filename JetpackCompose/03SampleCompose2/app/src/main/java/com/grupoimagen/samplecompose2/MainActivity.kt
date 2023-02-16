package com.grupoimagen.samplecompose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleCompose2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    //ImageMessageCard()
                    //MessageCard(Message("Android", "Jetpack Compose"))
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Column {
        Text(text = msg.author,
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2)
        // Add a vertical space between the author and message texts
        Spacer(modifier = Modifier.height(4.dp))
        Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
            Text(
                text = msg.body,
                modifier = Modifier.padding(all = 4.dp),
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    SampleCompose2Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(
                msg = Message("Colleague", "Hey, take a look at Jetpack Compose")
            )
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
//@Preview(showBackground = true)
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
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
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

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    SampleCompose2Theme {
        Conversation(SampleData.conversationSample)
    }
}