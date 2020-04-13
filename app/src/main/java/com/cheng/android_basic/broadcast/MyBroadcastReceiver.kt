package com.cheng.android_basic.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import com.cheng.android_basic.util.ALARM_RECEIVER_NAME
import com.cheng.android_basic.util.NOTIFICATION_ID
import com.cheng.android_basic.util.NotificationUtil

class MyBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.action.equals(ALARM_RECEIVER_NAME)) {
            val b = intent.extras
            val notificationBuilder = NotificationUtil().createNotification(context!!)
            with(NotificationManagerCompat.from(context)) {
                notify(NOTIFICATION_ID, notificationBuilder.build())
            }
        } else if (intent.action.equals("android.intent.action.BOOT_COMPLETED")) {
            // if the device restarts, set the alarm again
            val saveData = SaveData(context!!)
            saveData.setAlarm()
        }
    }
}