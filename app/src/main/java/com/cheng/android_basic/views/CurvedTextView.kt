package com.cheng.android_basic.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView

class CurvedTextView constructor(
    context: Context, attrs: AttributeSet?, defStyleAttr: Int
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var color = 0

    init {
        val paint = Paint()
        paint.color = Color.BLUE
    }

    fun setColor(colorString: String) {
        color = Color.parseColor(colorString)
        paint.color = color
    }

    fun setRadius(radius: Float) {
        val shape = GradientDrawable()
        shape.cornerRadius = radius
        background = shape
    }
}