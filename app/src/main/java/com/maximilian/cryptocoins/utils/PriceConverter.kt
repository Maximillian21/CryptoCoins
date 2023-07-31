package com.maximilian.cryptocoins.utils

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

object PriceConverter {
    fun formatCryptoPrice(price: BigDecimal): String {
        val decimalFormat = DecimalFormat("#,##0.#######$")
        return decimalFormat.format(price.setScale(5, RoundingMode.HALF_UP))
    }

    fun formatLargeNumber(number: Long): String {
        val suffixes = listOf("", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion")
        var num = number
        var index = 0
        while (num >= 1000) {
            num /= 1000
            index++
        }
        val decimalFormat = DecimalFormat("#,##0.##")
        return "$ " + decimalFormat.format(num) + " " + suffixes[index]
    }
}