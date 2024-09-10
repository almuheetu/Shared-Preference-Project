package com.example.sharedpreferenceproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferenceproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferenceManager: SharedPreferenceManager
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPreferenceManager = SharedPreferenceManager(this)

        binding.countBtn.setOnClickListener {
            val currentCount = sharedPreferenceManager.read("count")
            sharedPreferenceManager.save("count", currentCount + 1)
            updateResult()
        }
        binding.clearBtn.setOnClickListener {
            sharedPreferenceManager.clear("count")
            updateResult()
        }

    }


    private fun updateResult() {
        val count = sharedPreferenceManager.read("count")
        binding.textViewResult.text = "Result: $count"
    }
}


