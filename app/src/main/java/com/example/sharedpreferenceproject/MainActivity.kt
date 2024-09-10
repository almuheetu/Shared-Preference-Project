package com.example.sharedpreferenceproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferenceproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferenceManager: SharedPreferenceManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPreferenceManager = SharedPreferenceManager(this)
        updateResult()

        binding.countBtn.setOnClickListener {
            val currentCount = sharedPreferenceManager.read()
            val newCount = Count(currentCount.counter + 1)
            sharedPreferenceManager.save(newCount)
            updateResult()
        }

        binding.clearBtn.setOnClickListener {
            sharedPreferenceManager.clear()
            updateResult()
        }
    }

    private fun updateResult() {
        val count = sharedPreferenceManager.read()
        binding.textViewResult.text = "Result: ${count.counter}"
    }
}





































