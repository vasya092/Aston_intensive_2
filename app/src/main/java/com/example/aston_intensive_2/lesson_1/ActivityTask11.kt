package com.example.aston_intensive_2.lesson_1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.aston_intensive_2.R

/**
 * Home Work 1.1 Android Studio and Hello World
 * Link: https://developer.android.com/codelabs/android-training-hello-world
 * Задание: Создать проект и вызвать разные функции логирования
 */
class ActivityTask11 : AppCompatActivity() {

    private val tag = ActivityTask11::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_1_1)
        //Homework
        Log.d(tag, "Debug Message")
        Log.e(tag, "Error Message")
        Log.w(tag, "Warn Message")
        Log.v(tag, "Verbose Message")
        Log.i(tag, "Info Message")
    }
}