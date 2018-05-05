package com.github.tuvy.vendingmachine

class MainViewModel : ViewModel {

    val cocaCola = Drink(
            id = 0,
            name = R.string.drink_name_coca_cola,
            price = 150,
            priceLabel = Drink.labeler(150),
            image = R.drawable.drink_image_coca_cola,
            type = Drink.Type.Cold)
    val cocaColaPlusZero = Drink(
            id = 1,
            name = R.string.drink_name_coca_cola_plus_zero,
            price = 160,
            priceLabel = Drink.labeler(160),
            image = R.drawable.drink_image_coca_cola_plus_zero,
            type = Drink.Type.Cold
    )

    val coin10 = Coin(
            value = 10,
            label = Coin.labeler(10)
    )
    val coin50 = Coin(
            value = 50,
            label = Coin.labeler(50)
    )
    val coin100 = Coin(
            value = 100,
            label = Coin.labeler(100)
    )

    lateinit var selectedProduct: Drink
    var total: Int = 0

    override fun onCreate() {
    }

    override fun onBind() {
    }

    override fun onDestroy() {
    }

    fun updateTotalFee(value: Int) {
        total += value
    }

    fun selectProduct(drink: Drink) {
        selectedProduct = drink
    }

    fun purchase(): Boolean {
        val gap = total - selectedProduct.price
        if (gap < 0) {
            return false
        }

        return true
    }
}