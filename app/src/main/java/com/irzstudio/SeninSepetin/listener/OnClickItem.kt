package com.irzstudio.SeninSepetin.listener

import com.irzstudio.SeninSepetin.model.product.ProductEntity

interface OnClickItem {
    fun onClick(productEntity: ProductEntity)
}

interface OnClickItemAndAdd {
    fun onClick(productEntity: ProductEntity)
    fun onClickAdd(productEntity: ProductEntity)
}

interface OnClickItemAddRemove {
    fun onClick(productEntity: ProductEntity)
    fun onClickAdd(productEntity: ProductEntity)
    fun onClickSubstract(productEntity: ProductEntity)
    fun onClickRemove(productEntity: ProductEntity)

}