package com.irzstudio.SeninSepetin.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.SeninSepetin.data.Repository
import com.irzstudio.SeninSepetin.model.product.ProductEntity
import com.irzstudio.SeninSepetin.utill.ProductSavedType
import io.reactivex.disposables.CompositeDisposable

class ProductViewModel(private val repository : Repository): ViewModel() {

    private val _clothes = MutableLiveData<ArrayList<ProductEntity>>()
    val clothes: LiveData<ArrayList<ProductEntity>> = _clothes

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun showDataClothes() {
        val beveragesDisposable = repository.getClothes()
            .doOnSubscribe { }
            .doFinally { }
            .subscribe(
                { _clothes.postValue(it) },
                { _errorMessage.postValue(it.localizedMessage) })
        compositeDisposable.add(beveragesDisposable)
    }

    fun addToCahar(productEntity: ProductEntity) {
        repository.addToCart(productEntity)
    }

    fun removeProduct(productEntity: ProductEntity) {
        repository.removeProductCart(productEntity.id, ProductSavedType.CART)
    }
}