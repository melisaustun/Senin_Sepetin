package com.irzstudio.SeninSepetin.ui.activity


import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.irzstudio.SeninSepetin.R
import com.irzstudio.SeninSepetin.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registrasi.*


class RegistrasiActivity : AppCompatActivity() {
    private val sharedPref: PreferencesHelper by lazy {
        PreferencesHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        supportActionBar?.setTitle("seninsepetin")
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getResources().getColor(R.color.white)));
        supportActionBar?.hide()

        RegOrSignIn()
        navigationToLogin()
    }

    private fun RegOrSignIn() {
        btn_get_started.setOnClickListener {
            when {
                et_user.text.isEmpty() -> {
                    et_user.error = null
                    et_user.requestFocus()
                    Toast.makeText(this, "Kullanıcı adı giriniz", Toast.LENGTH_SHORT).show()
                }
                et_email_login2.text.isEmpty() -> {
                    et_email_login2.error = null
                    et_email_login2.requestFocus()
                    Toast.makeText(this, "Email giriniz", Toast.LENGTH_SHORT).show()
                }
                et_pass_login.text.isEmpty() -> {
                    et_pass_login2.error = null
                    et_pass_login2.requestFocus()
                    Toast.makeText(this, "Şifre giriniz", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    startActivity(Intent(applicationContext, LoginActivity::class.java))
                }
            }
        }
    }
    private fun navigationToLogin() {
        btn_get_started.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }
    }
}
