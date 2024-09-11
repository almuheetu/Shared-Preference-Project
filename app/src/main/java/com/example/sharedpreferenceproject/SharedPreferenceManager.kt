package com.example.sharedpreferenceproject

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPreferenceManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun save(count: Count) {
        sharedPreferences.edit().putString("count", Gson().toJson(count)).apply()
    }

    fun read(): Count? {
        val data = sharedPreferences.getString("count", null)
        if (data == null) {
            return null
        }
        return gson.fromJson(data, Count::class.java)
    }

    fun clear() {
        sharedPreferences.edit().putString("count", gson.toJson(Count(0))).apply()

    }
}

