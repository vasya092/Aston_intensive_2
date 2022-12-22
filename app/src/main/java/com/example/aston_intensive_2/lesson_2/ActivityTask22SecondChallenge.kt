package com.example.aston_intensive_2.lesson_2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.aston_intensive_2.R
import com.example.aston_intensive_2.databinding.ActivityTask22SecondChallengeBinding

/**
 * Challenge 2.2 Activity[2] and Challenge 2.3 Activity lifecycle and state
 * Link: https://developer.android.com/codelabs/android-training-activity-lifecycle-and-state
 * Задание: Создать две активити. Одна отображает список продуктов, вторая список, товаров, которые можно добавить.
 * Challenge 2.3 - добавить editText и кнопку, для открытия карты с локацией
 */
class ActivityTask22SecondChallenge : AppCompatActivity() {

    private var _binding: ActivityTask22SecondChallengeBinding? = null
    val binding: ActivityTask22SecondChallengeBinding
        get() = _binding
            ?: throw IllegalStateException("Error binding")

    private var productsIdArray: ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTask22SecondChallengeBinding.inflate(layoutInflater)
        productsIdArray = intent.getIntegerArrayListExtra(PRODUCTS_KEY) ?: arrayListOf()
        setContentView(binding.root)

        with(binding) {
            buttonProductApple.setOnClickListener() {
                addItemAndGoToActivity(0)
            }
            buttonProductBread.setOnClickListener(){
                addItemAndGoToActivity(1)
            }

            buttonProductMilk.setOnClickListener(){
                addItemAndGoToActivity(2)
            }

            buttonProductJuice.setOnClickListener(){
                addItemAndGoToActivity(3)
            }

            buttonProductOrange.setOnClickListener(){
                addItemAndGoToActivity(4)
            }
        }

        binding.openStoreLocationButton.setOnClickListener{
            val uri = Uri.parse(getString(R.string.address_template_string) + binding.storeEditText.text.toString())
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    /**
     * Добавление итемов, если их меньше, чем 10
     */
    private fun addItemAndGoToActivity(itemId: Int) {
        if(productsIdArray.size < MAX_ITEMS) {
            productsIdArray.add(itemId)
        } else {
            Toast.makeText(this, getString(R.string.no_more_10), Toast.LENGTH_LONG).show()
        }
        backToMainActivity()
    }

    /**
     * Обработка нажатия кнопки назад на телефоне
     */
    override fun onBackPressed() {
        backToMainActivity()
    }

    /**
     * Обработка нажатия кнопки назад на тулбаре
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            backToMainActivity()
        }
        return true
    }

    /**
     * Формирование ответа и возвращение на основное активити
     */
    private fun backToMainActivity() {
        val replyIntent = intent.putExtra(PRODUCTS_KEY, productsIdArray)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    companion object {
        const val MAX_ITEMS = 10
    }
}