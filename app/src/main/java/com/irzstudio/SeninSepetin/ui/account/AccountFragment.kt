package com.irzstudio.SeninSepetin.ui.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.irzstudio.SeninSepetin.R

import com.irzstudio.SeninSepetin.ui.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : Fragment(R.layout.fragment_account) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_favorite.setOnClickListener {
            Toast.makeText(requireActivity(), "Çıkış yapıldı", Toast.LENGTH_SHORT).show()
            startActivity(Intent(activity, LoginActivity::class.java)) }

        siparislerim.setOnClickListener {
            Toast.makeText(requireActivity(), "Siparişlerim", Toast.LENGTH_SHORT).show()
             }

        kuponlarim.setOnClickListener {
            Toast.makeText(requireActivity(), "Kuponlarım", Toast.LENGTH_SHORT).show()
             }

        kayitli_kartlarim.setOnClickListener {
            Toast.makeText(requireActivity(), "Kayıtlı Kartlarım", Toast.LENGTH_SHORT).show()
            }

        yardim.setOnClickListener {
            Toast.makeText(requireActivity(), "Yardım", Toast.LENGTH_SHORT).show()
            }

        hakkimizda.setOnClickListener {
            Toast.makeText(requireActivity(), "Hakkımızda", Toast.LENGTH_SHORT).show()
            }

        adreslerim.setOnClickListener {
            Toast.makeText(requireActivity(), "Adreslerim", Toast.LENGTH_SHORT).show()
            }

        hesap_ayarlarim.setOnClickListener {
            Toast.makeText(requireActivity(), "Hesap Ayarlarım", Toast.LENGTH_SHORT).show()
            }

        bildirimlerim.setOnClickListener {
            Toast.makeText(requireActivity(), "Bildirimlerim", Toast.LENGTH_SHORT).show()
            }
    }

}
