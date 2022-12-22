package com.example.aston_intensive_2.lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aston_intensive_2.R

/**
 * Challenge 1.1 Android Studio and Hello World
 * Link: https://developer.android.com/codelabs/android-training-hello-world
 * Задание: Изменить hello world на свой текст, а так же создать код, вызывающий exception.
 */
class ActivityTask11Challenge : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_1_1_challenge)

        //Вызов log.e с Exception
        val divisible = 5
        var divider = 1
        var result = 0

        divider = 0
        try {
            result = divisible / divider
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

    companion object {
        const val TAG = "Challenge Error"
    }
}