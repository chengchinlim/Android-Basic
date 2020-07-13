package com.cheng.android_basic.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cheng.android_basic.R

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)

        ViewUtil.setRadius(this, R.id.textView)
    }
}