package com.example.alarmmanagerexample

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.vicky.alarmmanagerexample.R
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var alarmManager: AlarmManager
    val btn_create1 = findViewById<Button>(R.id.btn_create)
    val edt_timer1 = findViewById<EditText>(R.id.edt_timer)
    val btn_cancel1 = findViewById<Button>(R.id.btn_cancel)
    val btn_update1 = findViewById<Button>(R.id.btn_update)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        btn_create1.setOnClickListener {
            val second = edt_timer1.text.toString().toInt() * 1000
            val intent = Intent(context, Receiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("MainActivity", " Create : " + Date().toString())
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + second, pendingIntent)
        }
//        btn_update1.setOnClickListener {
//            val second = edt_timer1.text.toString().toInt() * 1000
//            val intent = Intent(context, Receiver::class.java)
//            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//            Log.d("MainActivity", " Update : " + Date().toString())
//            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + second, pendingIntent)
//        }
//        btn_cancel1.setOnClickListener {
//            val intent = Intent(context, Receiver::class.java)
//            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//            Log.d("MainActivity", " Cancel : " + Date().toString())
//            alarmManager.cancel(pendingIntent)
//        }

    }

    class Receiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("MainActivity", " Receiver : " + Date().toString())
        }
    }
}