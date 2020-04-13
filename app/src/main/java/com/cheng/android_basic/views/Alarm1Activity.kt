package com.cheng.android_basic.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cheng.android_basic.R
import com.cheng.android_basic.broadcast.SaveData
import kotlinx.android.synthetic.main.activity_alarm1.*

class Alarm1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm1)

        val saveData = SaveData(applicationContext)
        val time = "${saveData.getHour()}:${saveData.getMin()}"
        tv_show_time.text = time
    }

    fun setTime(hr: Int, min: Int) {
        val time = "$hr: $min"
        tv_show_time.text = time

        val saveData = SaveData(applicationContext)
        saveData.saveToSharedPref(hr, min)
        saveData.setAlarm()
    }

    fun onSetTimeClicked(v: View) {
        val popTimeFragment = SetTimeFragment()
        popTimeFragment.show(supportFragmentManager, "Select time")
    }
}
