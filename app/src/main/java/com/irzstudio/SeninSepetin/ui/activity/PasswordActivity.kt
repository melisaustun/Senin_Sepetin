package com.irzstudio.SeninSepetin.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.irzstudio.SeninSepetin.R
import com.irzstudio.SeninSepetin.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.activity_password.*
import kotlinx.android.synthetic.main.activity_registrasi.*

class PasswordActivity : AppCompatActivity() {
    private val sharedPref: PreferencesHelper by lazy {
        PreferencesHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        supportActionBar?.hide()
        forget()
    }

    private fun forget() {
        btn_update.setOnClickListener {
            when {
                email_login.text.isEmpty() -> {
                    email_login.error = null
                    email_login.requestFocus()
                    Toast.makeText(this, "Lütfen kayıtlı e-mail giriniz", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    startActivity(Intent(applicationContext, LoginActivity::class.java))
                    Toast.makeText(this, "Kod gönderildi", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}