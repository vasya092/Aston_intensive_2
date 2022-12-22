package com.example.aston_intensive_2.lesson_2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.aston_intensive_2.R
import com.example.aston_intensive_2.databinding.ActivityTask23Binding

/**
 * HomeWork 2.3 Implicit intents
 * Link: https://developer.android.com/codelabs/android-training-activity-with-implicit-inten
 * Задание: Сделать активити с 3мя полями и кнопками открытия c implict intents
 */
class ActivityTask23 : AppCompatActivity() {

    private var _binding: ActivityTask23Binding? = null
    val binding: ActivityTask23Binding
        get() = _binding
            ?: throw IllegalStateException("Error binding")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTask23Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            openWebsiteButton.setOnClickListener{
                val uri = Uri.parse(websiteEdittext.text.toString())
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }

            openLocationButton.setOnClickListener{
                val uri = Uri.parse(getString(R.string.address_template_string) + locationEdittext.text.toString())
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }

            shareTextButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                val inputText = shareEdittext.text.toString()
                intent.putExtra(Intent.EXTRA_TEXT, inputText)
                startActivity(intent)
            }

            takePictureButton.setOnClickListener{
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
            }
        }
    }
}