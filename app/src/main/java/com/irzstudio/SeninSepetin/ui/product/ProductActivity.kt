package com.irzstudio.SeninSepetin.ui.product

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.irzstudio.SeninSepetin.R
import com.irzstudio.SeninSepetin.adapter.ClothesAdapter
import com.irzstudio.SeninSepetin.listener.OnClickItemAndAdd
import com.irzstudio.SeninSepetin.model.product.ProductEntity
import com.irzstudio.SeninSepetin.ui.activity.MainActivity
import com.irzstudio.SeninSepetin.ui.detailproduct.DetailProductActivity
import com.irzstudio.SeninSepetin.utill.Constant
import kotlinx.android.synthetic.main.activity_product.*
import org.koin.android.viewmodel.ext.android.viewModel

class ProductActivity : AppCompatActivity() {

    private val clothesAdapter: ClothesAdapter by lazy {
        ClothesAdapter()
    }

    private val viewModel: ProductViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        supportActionBar?.setTitle("seninsepetin")
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getResources().getColor(R.color.whitesmoke)));

        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setLogo(R.drawable.spt);
        getSupportActionBar()?.setDisplayUseLogoEnabled(true);

        observeClothes()
        setListGroceries()
        backToMainActivity()
        viewModel.showDataClothes()
    }

    private fun observeClothes() {
        viewModel.clothes.observe(this) {
            clothesAdapter.setDataAdapter(it)
        }
    }

    private fun setListGroceries() {
        rv_clothes.setHasFixedSize(true)
        rv_clothes.adapter = clothesAdapter
        rv_clothes.layoutManager = GridLayoutManager(this, 2)
        clothesAdapter.onClickListener = object : OnClickItemAndAdd {
            override fun onClick(productEntity: ProductEntity) {
                val intent = Intent(this@ProductActivity, DetailProductActivity::class.java)
                intent.putExtra(Constant.DATA, productEntity)
                startActivity(intent)
            }

            override fun onClickAdd(productEntity: ProductEntity) {
                addProductToCart(productEntity)
            }
        }
    }

    private fun backToMainActivity() {
        btn_back.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }

    private fun addProductToCart(productEntity: ProductEntity) {
        if (productEntity.qty == 0) {
            viewModel.addToCahar(productEntity)
            Toast.makeText(applicationContext, "Sepete eklendi", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.removeProduct(productEntity)
            Toast.makeText(applicationContext, "Sepetten kaldırıldı.", Toast.LENGTH_SHORT).show()
        }
    }
}