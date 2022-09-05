package com.app.sharepreferencecleancode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.sharepreferencecleancode.databinding.ActivityMainBinding
import com.app.sharepreferencecleancode.helper.Constant
import com.app.sharepreferencecleancode.helper.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferenceHelper = PreferenceHelper(this)

        binding.btnLogin.setOnClickListener {
            onClick()
        }
    }

    private fun onClick() {
        if (binding.inputEmail.text.isNotEmpty() && binding.inputPassword.text.isNotEmpty()) {
            preferenceHelper.put(Constant.PREF_EMAIL, binding.inputEmail.text.toString())
            preferenceHelper.put(Constant.PREF_PASSWORD, binding.inputPassword.text.toString())
            preferenceHelper.put(Constant.PREF_IS_LOGIN, true)
            moveActivity()
        }
    }

    private fun moveActivity() {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
    }

    override fun onStart() {
        super.onStart()
        if (preferenceHelper.getBoolean(Constant.PREF_IS_LOGIN)) {
            moveActivity()
        }
    }
}