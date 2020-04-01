package com.a.flipdigit

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var i = 0
        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                filipSingle.setDigit(i , true)
                flip.setValue(i *50 , true)
                i++
            }

            override fun onFinish() {
            }
        }.start()

    }

}
