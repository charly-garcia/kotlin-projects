package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstcomposeapp.components.MyNetworkImage
import com.example.myfirstcomposeapp.components.animations.MyAnimatedVisibility
import com.example.myfirstcomposeapp.components.layouts.MyBasicConstraintLayout
import com.example.myfirstcomposeapp.components.layouts.MyBox
import com.example.myfirstcomposeapp.components.layouts.MyColumn
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    //MyBox()
                    //MyColumn(Modifier.padding(innerPadding))
                    //MyBasicConstraintLayout(Modifier.padding(innerPadding))
                    //MyAnimatedVisibility()
                    MyNetworkImage()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        //Greeting("Android")
        MyBox()
    }
}