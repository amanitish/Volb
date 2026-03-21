package com.example.volumelogger

import android.os.Bundle
import android.widget.TextView
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scrollView = ScrollView(this)
        val textView = TextView(this).apply {
            paddingLeft = 50; paddingTop = 50
            textSize = 16f
        }
        val logFile = File(filesDir, "logs.txt")
        textView.text = if (logFile.exists()) "Logs:\n\n${logFile.readText()}" else "No logs yet."
        scrollView.addView(textView)
        setContentView(scrollView)
    }
}
