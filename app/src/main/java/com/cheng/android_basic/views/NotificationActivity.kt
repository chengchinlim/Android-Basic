package com.cheng.android_basic.views

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.cheng.android_basic.R
import com.cheng.android_basic.util.NOTIFICATION_CHANNEL_ID
import com.cheng.android_basic.util.NOTIFICATION_ID
import com.cheng.android_basic.util.NotificationUtil

class NotificationActivity : AppCompatActivity() {

    private lateinit var notificationBuilder: NotificationCompat.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        notificationBuilder = NotificationUtil().createNotification(this)

    }

    fun onNextClicked(v: View) {
        with(NotificationManagerCompat.from(this)) {
            notify(NOTIFICATION_ID, notificationBuilder.build())
        }
    }
}
