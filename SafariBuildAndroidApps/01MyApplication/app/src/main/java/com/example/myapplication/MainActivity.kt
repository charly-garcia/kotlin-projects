package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        setContentView(webView)
        webView.loadUrl("https://www.google.com")*/
        Log.d(TAG, "onCreate")
        findViewById<Button>(R.id.enter_button)?.setOnClickListener {
            val greetingDisplay = findViewById<TextView>(R.id.greeting_display)
            val firstName = findViewById<TextInputEditText>(R.id.first_name)?.text.toString().trim()
            val lastName = findViewById<TextInputEditText>(R.id.last_name)?.text.toString().trim()

            if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
                val nameToDisplay = firstName.plus(" ").plus(lastName)
                greetingDisplay?.text = " ${getString(R.string.welcome_to_the_app)} ${nameToDisplay}!"
            } else {
                Toast.makeText(this, getString(R.string.please_enter_a_name), Toast.LENGTH_LONG).
                        apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }
}