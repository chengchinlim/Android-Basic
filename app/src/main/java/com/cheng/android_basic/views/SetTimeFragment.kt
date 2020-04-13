package com.cheng.android_basic.views

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.cheng.android_basic.R
import kotlinx.android.synthetic.main.fragment_set_time.*

class SetTimeFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_set_time, container, false)
        val doneBtn = myView.findViewById<Button>(R.id.btn_done)
        doneBtn.setOnClickListener {
            val activity = activity as Alarm1Activity
            if (Build.VERSION.SDK_INT >= 23) {
                activity.setTime(tp1.hour, tp1.minute)
            } else {
                activity.setTime(tp1.currentHour, tp1.currentMinute)
            }
            dismiss()
        }
        return myView
    }
}