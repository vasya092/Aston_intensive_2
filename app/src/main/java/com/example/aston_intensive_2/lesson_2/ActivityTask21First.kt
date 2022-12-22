package com.example.aston_intensive_2.lesson_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.aston_intensive_2.databinding.ActivityTask21FirstBinding
import com.example.aston_intensive_2.lesson_2.ActivityTask22.Companion.KEY_COUNT

/**
 * Homework 2.1 Activity [1] Activities and intents
 * Link: https://developer.android.com/codelabs/android-training-create-an-activity
 * Задание: Добавить к счетчику из предыдущих лаб переход на другую страницу с сохранением состояния.
 */

class ActivityTask21First : AppCompatActivity() {

    private var count = 0
        set(value) {
            field = value
            binding.showCount.text = value.toString()
        }

    private var _binding: ActivityTask21FirstBinding? = null
    val binding: ActivityTask21FirstBinding
        get() = _binding
            ?: throw IllegalStateException("Binding error")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTask21FirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonToast.setOnClickListener {
                val intent = Intent(this@ActivityTask21First, ActivityTask21Second::class.java)
                intent.putExtra(KEY_COUNT, count)
                resultLauncher.launch(intent)
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
     * Добавление возможности восстановить данные при возвращении на активити
     */
    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                count = data?.getIntExtra(KEY_COUNT, 0) ?: 0
            }
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
        count = savedInstanceState.getInt(KEY_COUNT, 0)
    }

    companion object {
        const val KEY_COUNT = "COUNT"
    }
}