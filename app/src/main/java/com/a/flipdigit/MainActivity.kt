package com.a.flipdigit

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                filipSingle.setDigit(i , true)
                i++
            }

            override fun onFinish() {
            }
        }.start()

    }

}
