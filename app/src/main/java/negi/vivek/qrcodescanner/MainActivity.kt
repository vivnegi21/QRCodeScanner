package negi.vivek.qrcodescanner

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient()

        val mediaType = "application/x-www-form-urlencoded".toMediaTypeOrNull()
        val body = RequestBody.create(mediaType, "url=https%3A%2F%2Fgoogle.com%2F")
        val request = Request.Builder()
            .url("https://url-shortener-service.p.rapidapi.com/shorten")
            .post(body)
            .addHeader("content-type", "application/x-www-form-urlencoded")
            .addHeader("X-RapidAPI-Key", "8bfef4fb5amsh4b11040595afd09p1a819djsn4cb04f497af6")
            .addHeader("X-RapidAPI-Host", "url-shortener-service.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()

    }

}
