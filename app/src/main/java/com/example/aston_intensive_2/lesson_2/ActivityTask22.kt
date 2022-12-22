package com.example.aston_intensive_2.lesson_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensive_2.databinding.ActivityTask22Binding

/**
 * HomeWork 2.2 Activity lifecycle and state
 * Link: https://developer.android.com/codelabs/android-training-activity-lifecycle-and-state
 * Задание: Сделать счетчик и edit text, сохранить состояние счетчика при перестройке экрана.
 */
class ActivityTask22 : AppCompatActivity() {

    private var _binding: ActivityTask22Binding? = null
    val binding: ActivityTask22Binding
        get() = _binding
            ?: throw IllegalStateException("Error binding")

    private var count = 0
        set(value) {
            field = value
            binding.countValue.text = value.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityTask22Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            countValue.text = count.toString()
            counterButton.setOnClickListener {
                countUp()
            }
        }
    }

    private fun countUp() {
        count++
    }

    /**
     * Сохранение состояния
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //Восстановление данных при перестроении view
        count = savedInstanceState.getInt(KEY_COUNT, 0)
    }

    companion object {
        const val KEY_COUNT = "KEY_COUNT"
    }
}