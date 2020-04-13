package com.cheng.android_basic.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cheng.android_basic.util.PARCELIZE_INTENT
import com.cheng.android_basic.R
import com.cheng.android_basic.util.SERIALIZE_INTENT
import com.cheng.android_basic.util.START_TIME_MILLIS_INTENT
import com.cheng.android_basic.models.PersonParcelize
import timber.log.Timber

class Parcelize2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelize2)

        val personParcelize = intent.getParcelableExtra<PersonParcelize>(PARCELIZE_INTENT)
        personParcelize?.run {
            val endTime = System.currentTimeMillis()
            val startTime = intent.getLongExtra(START_TIME_MILLIS_INTENT, 0L)
            Timber.i("Start time: $startTime")
            Timber.i("End time: $endTime")
            Timber.i("Duration of passing parcelize object is ${endTime - startTime}ms")
        }
        val personSerialize = intent.getSerializableExtra(SERIALIZE_INTENT)
        personSerialize?.run {
            val endTime = System.currentTimeMillis()
            val startTime = intent.getLongExtra(START_TIME_MILLIS_INTENT, 0L)
            Timber.i("Start time: $startTime")
            Timber.i("End time: $endTime")
            Timber.i("Duration of passing serialized object is ${endTime - startTime}ms")
        }
    }
}
