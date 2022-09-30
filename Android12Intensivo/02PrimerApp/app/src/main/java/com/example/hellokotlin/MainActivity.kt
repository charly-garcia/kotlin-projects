package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.TextView

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    var tts:TextToSpeech? = null
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this, this)

        //var message = findViewById<TextView>(R.id.textView)
        textView = findViewById(R.id.textView)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            textView.text = "Listo!"
        } else {
            textView.text = "No disponible :("
        }
    }


}