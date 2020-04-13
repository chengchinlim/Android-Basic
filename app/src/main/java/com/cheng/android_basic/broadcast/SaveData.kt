package com.cheng.android_basic.broadcast

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.cheng.android_basic.util.ALARM_RECEIVER_NAME
import java.util.*

class SaveData(c: Context) {

    private val context = c
    private val sharedPreferences
            = context.getSharedPreferences("myref", Context.MODE_PRIVATE)

    fun saveToSharedPref(hr: Int, min: Int) {
        sharedPreferences.edit().putInt("hr", hr).apply()
        sharedPreferences.edit().putInt("min", min).apply()
    }

    fun getHour(): Int {
        return sharedPreferences.getInt("hr", -1)
    }

    fun getMin(): Int {
        return sharedPreferences.getInt("min", -1)
    }

    fun setAlarm() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, getHour())
        calendar.set(Calendar.MINUTE, getMin())
        calendar.set(Calendar.SECOND, 0)

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, MyBroadcastReceiver::class.java)
        intent.action = ALARM_RECEIVER_NAME
        val pendingIntent = PendingIntent.getBroadcast(context, 0,
            intent, PendingIntent.FLAG_UPDATE_CURRENT)
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY, pendingIntent)

    }
}