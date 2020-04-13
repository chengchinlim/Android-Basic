package com.cheng.android_basic.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.cheng.android_basic.*
import com.cheng.android_basic.models.PersonParcelize
import com.cheng.android_basic.models.PersonSerialize
import com.cheng.android_basic.util.PARCELIZE_INTENT
import com.cheng.android_basic.util.SERIALIZE_INTENT
import com.cheng.android_basic.util.START_TIME_MILLIS_INTENT
import timber.log.Timber

/* My experiment Serialize vs Parcelize
* Passing list of 1000 elements to another activity
*   Serialize: 96ms, Parcelize: 45ms
* Passing list of 10,000 elements to another activity
*   Serialize: 227ms, Parcelize: 47ms
*
* */

class ParcelizeActivity : AppCompatActivity() {

    private lateinit var personParcelize: PersonParcelize
    private lateinit var personSerialize: PersonSerialize

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelize)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        val list = ArrayList<Double>()
        for (i in 0..1000) {
            list.add(1.0)
        }

        personParcelize = PersonParcelize("Parcelize", list)
        personSerialize = PersonSerialize("Serialize", list)
    }

    fun onNextClicked(v: View) {
        val nextIntent = Intent(this, Parcelize2Activity::class.java)
        val nowMillis = System.currentTimeMillis()
        nextIntent.putExtra(START_TIME_MILLIS_INTENT, nowMillis)
        nextIntent.putExtra(PARCELIZE_INTENT, personParcelize)
        nextIntent.putExtra(SERIALIZE_INTENT, personSerialize)
        val btn = v as Button
        if (btn.id == R.id.btn_next) {
            startActivity(nextIntent)
        }
    }
}
