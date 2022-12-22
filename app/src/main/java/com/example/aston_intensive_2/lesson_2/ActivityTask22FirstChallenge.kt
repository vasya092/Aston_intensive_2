package com.example.aston_intensive_2.lesson_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aston_intensive_2.databinding.ActivityTask22ChallengeBinding
import com.example.aston_intensive_2.ui.ProductsListAdapter

/**
 * Challenge 2.2 Activity[1] Activity lifecycle and state
 * Link: https://developer.android.com/codelabs/android-training-activity-lifecycle-and-state
 * Задание: Создать две активити. Одна отображает список продуктов, вторая список, товаров, которые можно добавить.
 */
const val PRODUCTS_KEY = "PRODUCTS_IDS"

class ActivityTask22FirstChallenge : AppCompatActivity() {

    private var _binding: ActivityTask22ChallengeBinding? = null
    val binding: ActivityTask22ChallengeBinding
        get() = _binding
            ?: throw IllegalStateException("Error binding")

    private var productsIdArray: ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityTask22ChallengeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            productsList.layoutManager = LinearLayoutManager(this@ActivityTask22FirstChallenge)
            productsList.adapter =
                ProductsListAdapter(this@ActivityTask22FirstChallenge, productsIdArray)

            addItemButton.setOnClickListener {
                startActivityWithProducts()
            }
        }
    }

    /**
     * Добавление возможности восстановить данные при возвращении на активити
     */
    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                productsIdArray = data?.getIntegerArrayListExtra(PRODUCTS_KEY) ?: arrayListOf()
                binding.productsList.adapter = ProductsListAdapter(this, productsIdArray)
            }
        }

    /**
     * Переход с передачей текущих товаров, для восстановления.
     */
    private fun startActivityWithProducts() {
        val intent = Intent(this, ActivityTask22SecondChallenge::class.java)
        intent.putExtra(PRODUCTS_KEY, productsIdArray)
        resultLauncher.launch(intent)
    }

    /**
     * Сохранение состояния
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList(PRODUCTS_KEY, productsIdArray)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        productsIdArray = savedInstanceState.getIntegerArrayList(PRODUCTS_KEY) ?: arrayListOf()
        binding.productsList.adapter = ProductsListAdapter(this, productsIdArray)
    }

}