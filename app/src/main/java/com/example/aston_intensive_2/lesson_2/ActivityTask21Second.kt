package com.example.aston_intensive_2.lesson_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.aston_intensive_2.R
import com.example.aston_intensive_2.databinding.ActivityTask21SecondBinding

/**
 * Homework 2.1 Activity [2] Activities and intents
 * Link: https://developer.android.com/codelabs/android-training-create-an-activity
 * Задание: Добавить к счетчику из предыдущих лаб переход на другую страницу с сохранением состояния.
 */
class ActivityTask21Second : AppCompatActivity() {

    private var _binding: ActivityTask21SecondBinding? = null
    val binding: ActivityTask21SecondBinding
        get() = _binding
            ?: throw IllegalStateException("Binding Error")

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTask21SecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        count = intent.getIntExtra(ActivityTask21First.KEY_COUNT, 0)
        binding.activityTask21HelloText.text =
            getString(R.string.activity_task_2_1_hello_string_value, count)
    }

    /**
     * Обработка нажатия кнопки назад на панели телефона
     */
    override fun onBackPressed() {
        navigateUpWithSaveData()
    }

    /**
     * Обработка нажатия кнопки назад на тулбаре
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            navigateUpWithSaveData()
        }
        return true
    }

    /**
     * Функция возвращения на предыдущее активити с возвращением результата
     */
    private fun navigateUpWithSaveData() {
        val replyIntent = intent.putExtra(ActivityTask21First.KEY_COUNT, count)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}