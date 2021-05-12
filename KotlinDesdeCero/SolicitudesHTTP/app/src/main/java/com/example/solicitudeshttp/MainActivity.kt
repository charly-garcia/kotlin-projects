package com.example.solicitudeshttp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity(), CompletadoListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bValidarRed = findViewById<Button>(R.id.bValidarRed)
        val bSolicitudHTTP = findViewById<Button>(R.id.bSolicitudHTTP)
        val vVoller = findViewById<Button>(R.id.bVolley)

        bValidarRed.setOnClickListener {
            // código para validar red
            if(Network.hayRed(this)) {
                Toast.makeText(this, "Sí hay red", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No hay una conexión a Internet", Toast.LENGTH_LONG).show()
            }
        }

        bSolicitudHTTP.setOnClickListener {
            if(Network.hayRed(this)) {
                //Log.d("bSolicitudOnClick", descargarDatos("http://www.google.com"))
                DescargaURL(this).execute("https://www.google.com.mx")
            } else {
                Toast.makeText(this, "No hay una conexión a Internet", Toast.LENGTH_LONG).show()
            }
        }

        bVolley.setOnClickListener {
            if(Network.hayRed(this)) {
                solicitudHttpVolley("https://www.google.com.mx")
            } else {
                Toast.makeText(this, "No hay una conexión a Internet", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun descargaCompleta(resultado: String) {
        Log.d("descargaCompleta", resultado)
    }

    // Método para Volley
    private fun solicitudHttpVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
            try {
                Log.d("solicitudHTTPVolley", response)
            } catch (e:Exception) {

            }
        }, Response.ErrorListener {})

        queue.add(solicitud)
    }

}
