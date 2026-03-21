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
        val textView = TextView(this)
        
        // Fix: Use setPadding instead of trying to assign to paddingLeft/Top directly
        textView.setPadding(50, 50, 50, 50)
        textView.textSize = 16f
        
        val logFile = File(filesDir, "logs.txt")
        if (logFile.exists()) {
            textView.text = "Time Logs:\n\n" + logFile.readText()
        } else {
            textView.text = "No logs yet. Press Volume Down to record a timestamp!"
        }
        
        scrollView.addView(textView)
        setContentView(scrollView)
    }
}
