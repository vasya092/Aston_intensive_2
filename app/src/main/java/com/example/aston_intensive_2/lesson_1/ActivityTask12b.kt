package com.example.aston_intensive_2.lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aston_intensive_2.R
import com.example.aston_intensive_2.databinding.ActivityTask12bBinding
import com.example.aston_intensive_2.lesson_1.ActivityTask12.Companion.COUNT_KEY

/**
 * Homework 1.2b Part B: The layout editor
 * Link: https://developer.android.com/codelabs/android-training-layout-editor-part-b
 * Задание: Изменить верстку счетчика из предыдущего задания. Добавить кнопк zero.
 * Кнопка zero должна быть серой, когда значение не может быть обнулено.
 * Кнопка count должна менять цвет, в зависимости от четности.
 */
class ActivityTask12b : AppCompatActivity() {

    private var _binding: ActivityTask12bBinding? = null
    val binding: ActivityTask12bBinding
        get() = _binding
            ?: throw IllegalStateException("Binding error")

    private var count = 0
        set(value) {
            field = value
            binding.showCount.text = value.toString()
            binding.buttonCount.setBackgroundColor(
                if (value % 2 == 0) {
                    getColor(R.color.black)
                } else {
                    getColor(R.color.teal_200)
                }
            )
            binding.buttonZero.isEnabled = value > 0
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityTask12bBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonToast.setOnClickListener {
                Toast.makeText(this@ActivityTask12b,
                    getText(R.string.toast_message),
                    Toast.LENGTH_SHORT).show()
            }

            buttonCount.setOnClickListener {
                countUp()
            }

            buttonZero.setOnClickListener {
                resetCounter()
            }
        }
    }

    private fun countUp() {
        count++
    }

    private fun resetCounter() {
        count = 0
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
        count = savedInstanceState.getInt(ActivityTask12.COUNT_KEY, 0)
    }

    companion object {
        const val COUNT_KEY = "COUNT_KEY"
    }
}