package com.alom.androidstudy1

import android.content.SharedPreferences

class MemoRepositoryImpl(private val sharedPreferences: SharedPreferences) : MemoRepository {
    override fun getMemo(): String {
        return sharedPreferences.getString("memo", "").toString()
    }
    override fun setMemo(input: String) {
        val editor = sharedPreferences.edit()
        editor.putString("memo", input)
        editor.apply()
    }
}