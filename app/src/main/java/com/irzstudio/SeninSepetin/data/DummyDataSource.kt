package com.irzstudio.SeninSepetin.data

import com.irzstudio.SeninSepetin.R
import com.irzstudio.SeninSepetin.model.product.ProductEntity
import com.irzstudio.SeninSepetin.model.groceries.GroceriesData
import io.reactivex.Observable

class DummyDataSource {

    fun getExclusive(): Observable<ArrayList<ProductEntity>> {

        val dummy1 = ProductEntity(
            name = "Erkek Baskılı T-Shirt", description = "M beden",
            price = 89,
            picture = R.drawable.eust,
            id = 1
        )
        val dummy2 = ProductEntity(
            name = "Kadın Palazzo Pantolon", description = "S beden",
            price = 179,
            picture = R.drawable.kalt,
            id = 2
        )
        val dummy3 = ProductEntity(
            name = "Kare Yaka Örme Bluz", description = "L beden",
            price = 89,
            picture = R.drawable.kadinust,
            id = 3
        )
        val dummy4 = ProductEntity(
            name = "Siyah Erkek Ayakkabı", description = "42 numara",
            price = 99,
            picture = R.drawable.eayakkabi,
            id = 4
        )
        val dummy5 = ProductEntity(
            name = "Kadın Lila Sneaker", description = "38 numara",
            price = 256,
            picture = R.drawable.kadinaykkb,
            id = 14
        )
        val dummy6 = ProductEntity(
            name = "Apple iPhone 11", description = "128GB",
            price = 15000,
           picture = R.drawable.elektronik,
            id = 15
        )
        val dummy7 = ProductEntity(
            name = " A4 Okul Defteri ", description = "60 Yaprak",
            price = 152,
            picture = R.drawable.kitap,
            id = 16
        )

        val data = listOf(dummy1, dummy2, dummy3, dummy4, dummy5, dummy6, dummy7)
        return Observable.just(ArrayList(data))

    }

    fun getBestSelling(): Observable<ArrayList<ProductEntity>> {

        val dummy1 = ProductEntity(
            name = " A4 Okul Defteri ", description = "60 Yaprak",
            price = 152,
            picture = R.drawable.kitap,
            id = 5
        )
        val dummy2 = ProductEntity(
            name = "Kadın Lila Sneaker", description = "38 numara",
            price = 256,
            picture = R.drawable.kadinaykkb,
            id = 6
        )
        val dummy3 = ProductEntity(
            name = "Kare Yaka Örme Bluz", description = "L beden",
            price = 89,
            picture = R.drawable.kadinust,
            id = 7
        )
        val dummy4 = ProductEntity(
            name = "Siyah Erkek Ayakkabı", description = "42 numara",
            price = 99,
            picture = R.drawable.eayakkabi,
        )

        val data = listOf(dummy1, dummy2, dummy3, dummy4)
        return Observable.just(ArrayList(data))
    }

    fun getGroceries(): Observable<ArrayList<GroceriesData>> {

        val dummy1 = GroceriesData(name="Çok Satanlar", picture = R.drawable.yldz)
        val dummy2 = GroceriesData(name= "Mega Eyül", picture = R.drawable.mega)
        val dummy3 = GroceriesData(name = "Sana özel", picture = R.drawable.yldz)
        val dummy4 = GroceriesData(name = "İndirim!", picture = R.drawable.firsat)

        val data = listOf(dummy1, dummy2, dummy3, dummy4)
        return Observable.just(ArrayList(data))
    }

    fun getClothes(): Observable<ArrayList<ProductEntity>> {

        val dummy1 = ProductEntity(
            name = "Genç Timaş Kiraz Ağacı İle Aramızdaki Mesafe", description = "Normal Boy",
            price = 42,
            picture = R.drawable.roman,
            id = 8
        )

        val dummy2 = ProductEntity(
            name = "Kadın Siyah İnce Askılı", description = "M beden",
            price = 124,
            picture = R.drawable.elbise,
            id = 9
        )

        val dummy3 = ProductEntity(
            name = "Apple Macbook Air 13'' M1", description = "8gb 256gb Ssd Altın",
            price = 20000,
            picture = R.drawable.macbook,
            id = 10
        )

        val dummy4 = ProductEntity(
            name = "Erkek Siyah Italyan Kesim Pantolon", description = "30/32 beden",
            price = 259,
            picture = R.drawable.ealt,
            id = 11
        )

        val dummy5 = ProductEntity(
            name = "Reguler Fit Gömlek", description = "M beden",
            price = 199,
            picture = R.drawable.egomlek,
            id = 12
        )

        val dummy6 = ProductEntity(
            name = "Oversize Denim Ceket", description = "S beden",
            price = 522,
            picture = R.drawable.kceket,
            id = 13
        )

        val data = listOf(dummy1, dummy2, dummy3, dummy4, dummy5, dummy6)
        return Observable.just(ArrayList(data))
    }

    fun getSearchData(qword: String?): Observable<List<ProductEntity>> {
        val listData = listOf(getBestSelling(), getExclusive(),getClothes())
        val resultData = mutableListOf<ProductEntity>()

        return Observable.merge(listData).doOnNext{
            resultData.addAll(it)
        }
            .map {
                return@map resultData.filter {
                    it.name.contains(qword.orEmpty(), true)
                }
            }
    }

}