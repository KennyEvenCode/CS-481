package com.example.notifications_and_workmanager

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        findViewById<Button>(R.id.btnSend).setOnClickListener {
            sendNotification()
        }
    }
    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel:NotificationChannel = NotificationChannel("C10", "Title", NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "Description"
            }
            val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    @SuppressLint("MissingPermission")
    private fun sendNotification() {
        val title = findViewById<EditText>(R.id.etTitle).text.toString()
        val message = findViewById<EditText>(R.id.etMessage).text.toString()
        showAlert(title, message)
        val builder: NotificationCompat.Builder = NotificationCompat.Builder (this, "C10")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)){
            notify(10, builder.build())
        }
    }
    private fun showAlert(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle("You will see the following title and message as a notification")
            .setMessage("Title: $title\nMessage: $message")
            .setPositiveButton("Okay") {_,_ ->}
            .show()
    }
}