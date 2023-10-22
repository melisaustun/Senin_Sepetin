package com.irzstudio.SeninSepetin.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.irzstudio.SeninSepetin.R
import com.irzstudio.SeninSepetin.adapter.FavoriteAdapter
import com.irzstudio.SeninSepetin.helper.SwipeToDelete
import com.irzstudio.SeninSepetin.listener.OnClickItem
import com.irzstudio.SeninSepetin.model.product.ProductEntity
import com.irzstudio.SeninSepetin.ui.detailproduct.DetailProductActivity
import com.irzstudio.SeninSepetin.utill.Constant
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.android.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val viewModel: FavoriteViewModel by viewModel()

    private val favoriteAdapter: FavoriteAdapter by lazy {
        FavoriteAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListFavorite()
        observeFavoriteList()
        viewModel.loadDataFavorite()
    }

    private fun observeFavoriteList() {
        viewModel.favoriteProduct.observe(viewLifecycleOwner) {
            favoriteAdapter.setDataAdapter(it)
        }
    }

    private fun setListFavorite() {
        rv_favorite.setHasFixedSize(true)
        rv_favorite.adapter = favoriteAdapter

        favoriteAdapter.onClickListener = object : OnClickItem {
            override fun onClick(productEntity: ProductEntity) {
                val intent = Intent(activity, DetailProductActivity::class.java)
                intent.putExtra(Constant.DATA, productEntity)
                startActivity(intent)
            }

        }
        val itemTouchHelper = ItemTouchHelper(SwipeToDelete {
            viewModel.removeProduct(it)
            favoriteAdapter.deleteItem(it)
        })
        itemTouchHelper.attachToRecyclerView(rv_favorite)
        viewModel.loadDataFavorite()

    }
}