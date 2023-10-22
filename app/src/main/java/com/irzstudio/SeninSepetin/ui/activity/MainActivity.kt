package com.irzstudio.SeninSepetin.ui.activity

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.irzstudio.SeninSepetin.R
import com.irzstudio.SeninSepetin.ui.account.AccountFragment
import com.irzstudio.SeninSepetin.ui.cart.CartFragment
import com.irzstudio.SeninSepetin.ui.explore.ExploreFragment
import com.irzstudio.SeninSepetin.ui.favorite.FavoriteFragment
import com.irzstudio.SeninSepetin.ui.shop.ShopFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setTitle("seninsepetin")
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getResources().getColor(R.color.whitesmoke)));

        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setLogo(R.drawable.spt);
        getSupportActionBar()?.setDisplayUseLogoEnabled(true);

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_ust_giyim -> { Toast.makeText(this , "Üst Giyim", Toast.LENGTH_SHORT).show() }
                R.id.nav_ust_giyim2 -> { Toast.makeText(this, "Üst Giyim", Toast.LENGTH_SHORT).show() }
                R.id.nav_alt_giyim -> { Toast.makeText(this, "Alt Giyim", Toast.LENGTH_SHORT).show() }
                R.id.nav_alt_giyim2 -> { Toast.makeText(this, "Alt Giyim", Toast.LENGTH_SHORT).show() }
                R.id.nav_ayakkabi -> { Toast.makeText(this, "Ayakkabı", Toast.LENGTH_SHORT).show() }
                R.id.nav_ayakkabi2 -> { Toast.makeText(this, "Ayakkabı", Toast.LENGTH_SHORT).show() }
                R.id.nav_book -> { Toast.makeText(this, "Kitap & Kırtasiye", Toast.LENGTH_SHORT).show() }
                R.id.nav_elbise -> { Toast.makeText(this, "Elbise", Toast.LENGTH_SHORT).show() }
                R.id.nav_electronic -> { Toast.makeText(this, "Elektronik", Toast.LENGTH_SHORT).show() }
            }
            true
        }

        shopFragment()
        initBottomNavigation()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    private fun initBottomNavigation() {
        bottom_nav_bar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.shop -> shopFragment()
                R.id.explore -> exploreFragment()
                R.id.cart -> cartFragment()
                R.id.favorite -> favoriteFragment()
                R.id.account -> accountFragment()
            }
            true
        }
    }

    private fun shopFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, ShopFragment()).commit()
    }
    private fun exploreFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, ExploreFragment()).commit()
    }
    private fun cartFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, CartFragment()).commit()
    }
    private fun favoriteFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, FavoriteFragment()).commit()
    }
    private fun accountFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, AccountFragment()).commit()
    }

    fun navigateExplore(){
        bottom_nav_bar.selectedItemId = R.id.explore
    }

}