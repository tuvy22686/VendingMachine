package com.github.tuvy.vendingmachine

data class Coin(
        val value: Int,
        val label: String
) {
    companion object {
        fun labeler(value: Int): String {
            return value.toString() + "円玉"
        }
    }
}