package com.example.aston_intensive_2.lesson_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensive_2.databinding.ActivityTasks21SecondChallengeBinding

/**
 * Challenge 2.1 Activity [2] Activities and intents
 * Link: https://developer.android.com/codelabs/android-training-create-an-activity
 * Задание: Сделать активити с тремя кнопками, после перехода на каждую открывается страница, выводащая определенный текст.
 */
class ActivityTasks21SecondChallenge : AppCompatActivity() {

    private var _binding: ActivityTasks21SecondChallengeBinding? = null
    val binding: ActivityTasks21SecondChallengeBinding
        get() = _binding
            ?: throw IllegalStateException("Error binding")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTasks21SecondChallengeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Получение ресурса, в зависимости от нажатой кнопки
        val resId = intent.getIntExtra(ActivityTask21FirstChallenge.RES_ID, 0)
        binding.textWrapper.text = getString(resId)
    }
}