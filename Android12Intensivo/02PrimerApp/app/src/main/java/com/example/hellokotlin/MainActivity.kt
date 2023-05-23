package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    var tts:TextToSpeech? = null
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this, this)

        //var message = findViewById<TextView>(R.id.textView)
        textView = findViewById(R.id.tvStatus)
        findViewById<Button>(R.id.btnPlay).setOnClickListener { speak() }
    }

    private fun speak() {
        var message : String = findViewById<TextView>(R.id.tvStatus).text.toString()

        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            textView.text = "Hello Kotlin!"
            tts!!.setLanguage(Locale.US)
        } else {
            textView.text = "No disponible :("
        }
    }


}