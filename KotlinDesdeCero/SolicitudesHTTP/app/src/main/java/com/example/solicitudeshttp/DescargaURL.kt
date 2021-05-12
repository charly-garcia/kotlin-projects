package com.example.solicitudeshttp

import android.os.AsyncTask
import android.os.StrictMode
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class DescargaURL(var completadoListener: CompletadoListener?): AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg params: String): String? {
        try {
            return descargarDatos(params[0])
        } catch(e:IOException) {
            return null
        }
    }

    override fun onPostExecute(result: String?) {
        try {
            completadoListener?.descargaCompleta(result!!)
        } catch (e:Exception) {

        }
    }

    @Throws(IOException::class)
    private fun descargarDatos(url:String):String {

        //val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        //StrictMode.setThreadPolicy(policy)

        var inputStream: InputStream? = null

        try {
            val url = URL(url)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connect()
            inputStream = conn.inputStream
            return inputStream.bufferedReader().use {
                it.readText()
            }
        } catch (e2:Exception) {
            println(e2.message)
            return "Error en la petición HTTP"
        } finally {
            if(inputStream != null) {
                inputStream.close()
            }
        }
    }
}