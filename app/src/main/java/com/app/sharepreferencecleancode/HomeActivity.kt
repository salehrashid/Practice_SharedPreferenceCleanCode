package com.app.sharepreferencecleancode

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.sharepreferencecleancode.databinding.ActivityHomeBinding
import com.app.sharepreferencecleancode.helper.Constant
import com.app.sharepreferencecleancode.helper.PreferenceHelper

class HomeActivity : AppCompatActivity() {

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding as ActivityHomeBinding
    private lateinit var preferencesHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferencesHelper = PreferenceHelper(this)

        binding.btnLogout.setOnClickListener {
            onLogout()
        }
        getEmail()
    }

    private fun getEmail() {
        binding.textViewEmail.text = preferencesHelper.getString(Constant.PREF_EMAIL)
    }

    private fun onLogout() {
        clearData()
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }

    private fun clearData() {
        preferencesHelper.clearPref()
    }
}