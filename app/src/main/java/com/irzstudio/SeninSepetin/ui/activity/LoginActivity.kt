package com.irzstudio.SeninSepetin.ui.activity


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.irzstudio.SeninSepetin.R
import com.irzstudio.SeninSepetin.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_cart.*

class LoginActivity : AppCompatActivity() {

    private val sharedPref: PreferencesHelper by lazy {
        PreferencesHelper(this)
    }

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.setTitle("seninsepetin")
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getResources().getColor(R.color.white)));
        supportActionBar?.hide()

            loginOrSignIn()
            navigationToRegistrasi()
            forgetpassword()
        }

    private fun loginOrSignIn() {
        btn_sign_in.setOnClickListener {
            when {
                et_email_login.text.isEmpty() -> {
                    et_email_login.error = null
                    et_email_login.requestFocus()
                    Toast.makeText(this, "Lütfen e-mail giriniz", Toast.LENGTH_SHORT).show()
                }
                et_pass_login.text.isEmpty() -> {
                    et_pass_login.error = null
                    et_pass_login.requestFocus()
                    Toast.makeText(this, "Lütfen şifre giriniz", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }
            }

        }
    }

    private fun navigationToRegistrasi() {
        tv_sign_up.setOnClickListener {
            startActivity(Intent(applicationContext, RegistrasiActivity::class.java))
            finish()
        }
    }

    private fun forgetpassword() {
        forget_password.setOnClickListener {
            startActivity(Intent(applicationContext, PasswordActivity::class.java))
            finish()
        }
    }
}






