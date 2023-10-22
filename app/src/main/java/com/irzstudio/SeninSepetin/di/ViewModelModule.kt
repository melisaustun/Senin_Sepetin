package com.irzstudio.SeninSepetin.di

import com.irzstudio.SeninSepetin.ui.cart.CartViewModel
import com.irzstudio.SeninSepetin.ui.detailproduct.DetailProductViewModel
import com.irzstudio.SeninSepetin.ui.explore.ExploreViewModel
import com.irzstudio.SeninSepetin.ui.favorite.FavoriteViewModel
import com.irzstudio.SeninSepetin.ui.product.ProductViewModel
import com.irzstudio.SeninSepetin.ui.shop.ShopViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ShopViewModel(get()) }
    viewModel { ProductViewModel(get()) }
    viewModel { DetailProductViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { ExploreViewModel(get()) }
    viewModel { CartViewModel(get()) }
}