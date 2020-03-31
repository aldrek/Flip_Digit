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

//        flip.setValue( 1000, true)

//        flipItem.setDigit(1000, true)


        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

//                flip.setValue(i * 4, true)
                filipSingle.setDigit(i , true)
                i++
                //here you can have your logic to set text to edittext
            }

            override fun onFinish() {
            }
        }.start()

//        object : CountDownTimer(10000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//
//                flipItem.setDigit(i, true)
//
//                i++
//                //here you can have your logic to set text to edittext
//            }
//
//            override fun onFinish() {
//            }
//        }.start()
    }

}
