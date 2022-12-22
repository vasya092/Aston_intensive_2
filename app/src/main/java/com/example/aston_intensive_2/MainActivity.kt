package com.example.aston_intensive_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensive_2.databinding.ActivityMainBinding
import com.example.aston_intensive_2.lesson_1.*
import com.example.aston_intensive_2.lesson_2.*

/**
 * Main Activity. Aston Homework 2
 * Задание: Пройти первые 2 раздела кодлаб и выполнить homework и code challenge. Затем добавить
 * кнопки с переходом на активити с выполненными заданиями.
 * Link: https://developer.android.com/courses/fundamentals-training/toc-v2
 */
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding
        get() = _binding
            ?: throw IllegalStateException("Error binding")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            task11.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask11::class.java)
                startActivity(intent)
            }

            task11Challenge.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask11Challenge::class.java)
                startActivity(intent)
            }

            task12.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask12::class.java)
                startActivity(intent)
            }

            task12b.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask12b::class.java)
                startActivity(intent)
            }

            task13.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask13::class.java)
                startActivity(intent)
            }

            task14.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask14::class.java)
                startActivity(intent)
            }

            task21.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask21First::class.java)
                startActivity(intent)
            }

            task21Challenge.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask21FirstChallenge::class.java)
                startActivity(intent)
            }

            task22Challenge.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask22FirstChallenge::class.java)
                startActivity(intent)
            }

            task22.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask22::class.java)
                startActivity(intent)
            }

            binding.task23.setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityTask23::class.java)
                startActivity(intent)
            }
        }

    }

}