package com.github.tuvy.vendingmachine

data class Drink(
        val id: Int,
        val name: Int,
        val price: Int,
        val priceLabel: String,
        val image: Int,
        val type: Type
) {
    companion object {
        fun labeler(value: Int): String {
            return value.toString() + "円"
        }
    }

    enum class Type {
        Hot, Cold
    }
}