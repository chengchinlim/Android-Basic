package com.cheng.android_basic.views

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.widget.TextView

class ViewUtil {
    companion object {
        fun setRadius(activity: Activity, viewId: Int) {
            val shape = GradientDrawable()
            shape.cornerRadius = 25f
            shape.setColor(Color.RED)
            val textView = activity.findViewById<TextView>(viewId)
            textView.background = shape
        }
    }
}