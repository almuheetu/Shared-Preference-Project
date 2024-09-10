package com.example.sharedpreferenceproject

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun save(count: Count) {
        val editor = sharedPreferences.edit()
        editor.putInt("count", count.counter)
        editor.apply()
    }

    fun read(): Count {
        val count = sharedPreferences.getInt("count", 0)
        return Count(count)
    }

    fun clear() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}

