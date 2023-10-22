package com.irzstudio.SeninSepetin.ui.shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.irzstudio.SeninSepetin.R
import com.irzstudio.SeninSepetin.adapter.BestSellingAdapter
import com.irzstudio.SeninSepetin.adapter.ExclusiveAdapter
import com.irzstudio.SeninSepetin.adapter.GroceriesAdapter
import com.irzstudio.SeninSepetin.listener.OnClickItemAndAdd
import com.irzstudio.SeninSepetin.model.product.ProductEntity
import com.irzstudio.SeninSepetin.ui.activity.MainActivity
import com.irzstudio.SeninSepetin.ui.detailproduct.DetailProductActivity
import com.irzstudio.SeninSepetin.ui.product.ProductActivity
import com.irzstudio.SeninSepetin.utill.Constant
import com.irzstudio.SeninSepetin.utill.ProductSavedType
import kotlinx.android.synthetic.main.fragment_shop.*
import org.koin.android.viewmodel.ext.android.viewModel


class ShopFragment : Fragment(R.layout.fragment_shop) {

    private val exclusiveAdapter: ExclusiveAdapter by lazy {
        ExclusiveAdapter()
    }

    private val groceriesAdapter: GroceriesAdapter by lazy {
        GroceriesAdapter {
            startActivity(Intent(activity, ProductActivity::class.java))
        }
    }

    private val bestSellingAdapter: BestSellingAdapter by lazy {
        BestSellingAdapter()
    }

    private val viewModel: ShopViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        intentSearch()
        showBanner()

        setListExclusive()
        observeExclusiveOffer()

        setListBestSelling()
        observeBestSelling()

        setListGroceries()
        observeGroceries()

        viewModel.showDataExclusiveOffer()
        viewModel.showDataBestSelling()
        viewModel.showDataGroceries()

    }
    private fun intentSearch() {
        tv_search.setOnClickListener {
            (activity as MainActivity).navigateExplore()
        }
    }

    private fun showBanner() {
        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel(R.drawable.banner))
        imageList.add(SlideModel(R.drawable.banner2))
        imageList.add(SlideModel(R.drawable.banner3))

        image_slider.setImageList(imageList, ScaleTypes.CENTER_CROP)
    }

    private fun observeExclusiveOffer() {
        viewModel.exclusiveOffer.observe(viewLifecycleOwner) {
            exclusiveAdapter.setDataAdapter(it)
        }
    }

    private fun setListExclusive() {
        rv_exclusive_offer.setHasFixedSize(true)
        rv_exclusive_offer.adapter = exclusiveAdapter
        exclusiveAdapter.onClickListener = object : OnClickItemAndAdd {
            override fun onClick(productEntity: ProductEntity) {
                toDetailExclusifeOffer(productEntity)
            }

            override fun onClickAdd(productEntity: ProductEntity) {
                addProductToCart(productEntity, ProductSavedType.CART)
            }
        }
    }

    private fun observeGroceries() {
        viewModel.groceries.observe(viewLifecycleOwner) {
            groceriesAdapter.setDataAdapter(it)
        }
    }

    private fun setListGroceries() {
        rv_groceries.setHasFixedSize(true)
        rv_groceries.adapter = groceriesAdapter
    }

    private fun observeBestSelling() {
        viewModel.bestsSelling.observe(viewLifecycleOwner) {
            bestSellingAdapter.setDataAdapter(it)
        }
    }

    private fun setListBestSelling() {
        rv_best_selling.setHasFixedSize(true)
        rv_best_selling.adapter = bestSellingAdapter
        bestSellingAdapter.onClickListener = object : OnClickItemAndAdd {
            override fun onClick(productEntity: ProductEntity) {
                toDetailBestSelling(productEntity)
            }

            override fun onClickAdd(productEntity: ProductEntity) {
                addProductToCart(productEntity, ProductSavedType.CART)
            }
        }
    }

    private fun toDetailExclusifeOffer(productEntity: ProductEntity) {
        val intent = Intent(activity, DetailProductActivity::class.java)
        intent.putExtra(Constant.DATA, productEntity)
        startActivity(intent)
    }

    private fun toDetailBestSelling(productEntity: ProductEntity) {
        val intent = Intent(activity, DetailProductActivity::class.java)
        intent.putExtra(Constant.DATA, productEntity)
        startActivity(intent)
    }

    private fun addProductToCart(productEntity: ProductEntity, cart: Int) {
        viewModel.addToCahar(productEntity, ProductSavedType.CART)
        Toast.makeText(activity, "Sepete eklendi", Toast.LENGTH_SHORT).show()
    }
    
}