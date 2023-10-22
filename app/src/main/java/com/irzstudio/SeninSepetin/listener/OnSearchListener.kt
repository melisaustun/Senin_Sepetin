package com.irzstudio.SeninSepetin.listener

import com.irzstudio.SeninSepetin.model.product.ProductEntity

interface OnSearchListener {
    fun onSearch(productEntity: ProductEntity)
}