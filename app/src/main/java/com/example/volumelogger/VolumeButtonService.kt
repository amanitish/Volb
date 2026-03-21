package com.example.volumelogger
import android.accessibilityservice.AccessibilityService
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class VolumeButtonService : AccessibilityService() {
    override fun onKeyEvent(event: KeyEvent): Boolean {
        if (event.keyCode == KeyEvent.KEYCODE_VOLUME_DOWN && event.action == KeyEvent.ACTION_DOWN) {
            val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
            File(filesDir, "logs.txt").appendText("$timestamp\n")
            
            // This will show a small message on your screen immediately
            Toast.makeText(this, "Logged: $timestamp", Toast.LENGTH_SHORT).show()
        }
        return false 
    }
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}
}
