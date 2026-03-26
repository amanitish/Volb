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
        // We check for Volume Down and Action Down (when you first press it)
        if (event.keyCode == KeyEvent.KEYCODE_VOLUME_DOWN && event.action == KeyEvent.ACTION_DOWN) {
            val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
            
            try {
                File(filesDir, "logs.txt").appendText("$timestamp\n")
                // Toast.LENGTH_LONG stays on screen longer
                Toast.makeText(this, "Logged to Aman: $timestamp", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(this, "Error writing log", Toast.LENGTH_SHORT).show()
            }
            
            // Return true if you want to STOP the volume bar from moving
            // Return false if you want the volume to still change while logging
            return false 
        }
        return super.onKeyEvent(event)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}
}
