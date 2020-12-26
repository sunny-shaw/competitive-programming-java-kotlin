package leetcode.buyAndSellStock

/*
121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
* */

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)

    val maxProfit = maxProfit(prices)

    println(maxProfit)
}

fun maxProfit(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    prices.forEach { price ->
        if (price < minPrice) minPrice = price
        else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice
        }
    }

    return maxProfit
}
