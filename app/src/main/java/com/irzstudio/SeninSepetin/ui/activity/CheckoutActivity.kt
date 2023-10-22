package com.irzstudio.SeninSepetin.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.irzstudio.SeninSepetin.R
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.activity_login.*

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        supportActionBar?.hide()
        checkout()
    }
    private fun checkout() {
        checkout.setOnClickListener {
            when {
                kart_ad_soyad.text.isEmpty() -> {
                    kart_ad_soyad.error = null
                    kart_ad_soyad.requestFocus()
                    Toast.makeText(this, "Lütfen kart üzerindeki ad-soyad giriniz", Toast.LENGTH_SHORT).show()
                }
                kart_numarasi.text.isEmpty() -> {
                    kart_numarasi.error = null
                    kart_numarasi.requestFocus()
                    Toast.makeText(this, "Lütfen kart numarası giriniz", Toast.LENGTH_SHORT).show()
                }
                ay.text.isEmpty() -> {
                    ay.error = null
                    ay.requestFocus()
                    Toast.makeText(this, "Lütfen ay giriniz", Toast.LENGTH_SHORT).show()
                }
                yil.text.isEmpty() -> {
                    yil.error = null
                    yil.requestFocus()
                    Toast.makeText(this, "Lütfen yıl giriniz", Toast.LENGTH_SHORT).show()
                }
                cvv.text.isEmpty() -> {
                    cvv.error = null
                    cvv.requestFocus()
                    Toast.makeText(this, "Lütfen cvv giriniz", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    Toast.makeText(this, "Siparişiniz alındı!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

}