package com.example.aston_intensive_2.lesson_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.example.aston_intensive_2.R
import com.example.aston_intensive_2.databinding.ActivityTask21FirstChallengeBinding

/**
 * Challenge 2.1 Activity [1] Activities and intents
 * Link: https://developer.android.com/codelabs/android-training-create-an-activity
 * Задание: Сделать активити с тремя кнопками, после перехода на каждую открывается страница, выводащая определенный текст.
 */

class ActivityTask21FirstChallenge : AppCompatActivity() {

    private var _binding: ActivityTask21FirstChallengeBinding? = null
    val binding: ActivityTask21FirstChallengeBinding
        get() = _binding
            ?: throw IllegalStateException("Error binding")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTask21FirstChallengeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            buttonOne.setOnClickListener {
                startActivityWithResCode(R.string.challenge_text_first)
            }
            buttonTwo.setOnClickListener {
                startActivityWithResCode(R.string.challenge_text_second)
            }
            buttonThree.setOnClickListener {
                startActivityWithResCode(R.string.challenge_text_third)
            }
        }

    }

    private fun startActivityWithResCode(@StringRes resId: Int) {
        val intent = Intent(this, ActivityTasks21SecondChallenge::class.java)
        intent.putExtra(RES_ID, resId)
        this.startActivity(intent)
    }

    companion object {
        const val RES_ID = "RES"
    }

}