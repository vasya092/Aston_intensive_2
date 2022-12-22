package com.example.aston_intensive_2.lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aston_intensive_2.R
import com.example.aston_intensive_2.databinding.ActivityTask12Binding

/**
 * Challenge 1.2 Part A: Your first interactive UI
 * Link: https://developer.android.com/codelabs/android-training-layout-editor-part-a
 * Задание: Создать счетчик и переверстать его в формат указанный в задании
 */
class ActivityTask12 : AppCompatActivity() {

    private var _binding: ActivityTask12Binding? = null
    val binding: ActivityTask12Binding
        get() = _binding
            ?: throw IllegalStateException("Binding Error")

    private var count = 0
        set(value) {
            field = value
            binding.showCount.text = value.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTask12Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonToast.setOnClickListener {
                Toast.makeText(this@ActivityTask12,
                    getText(R.string.toast_message),
                    Toast.LENGTH_SHORT).show()
            }

            buttonCount.setOnClickListener {
                countUp()
            }
        }

    }

    private fun countUp() {
        count++
    }

    /**
     * Сохранение состояния и загрузка
     */

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(COUNT_KEY, 0)
    }

    companion object {
        const val COUNT_KEY = "COUNT_KEY"
    }
}