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
            try {
                File(filesDir, "logs.txt").appendText("$timestamp\n")
                Toast.makeText(this, "Aman Logged: $timestamp", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) { }
            return false 
        }
        return super.onKeyEvent(event)
    }
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}
}
