package com.example.a24012011221_raju_practical3_mad

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Browse URL
        findViewById<Button>(R.id.weburlbutton).setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com")
            )
            startActivity(intent)
        }

        // Dial Phone Number
        findViewById<Button>(R.id.phonenobutton).setOnClickListener {
            val intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:9898573586")
            )
            startActivity(intent)
        }

        // Open Call Log
        findViewById<Button>(R.id.callogbutton).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("content://call_log/calls")
            }
            startActivity(intent)
        }

        // Open Gallery
        findViewById<Button>(R.id.gallarybutton).setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"

            startActivity(intent)
        }

        // Open Camera
        findViewById<Button>(R.id.camerabutton).setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        // Open Alarm
        findViewById<Button>(R.id.alarmbutton).setOnClickListener {

            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_HOUR, 7)
                putExtra(AlarmClock.EXTRA_MINUTES, 0)
                putExtra(AlarmClock.EXTRA_MESSAGE, "Wake Up")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Alarm app not found", Toast.LENGTH_SHORT).show()
            }
        }

        // Open Login Activity
        findViewById<Button>(R.id.loginbutton).setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        // Edge to Edge Padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }
}

