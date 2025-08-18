/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

private fun maxProfit(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    prices.forEach { price ->
        minPrice = minOf(minPrice, price)
        maxProfit = maxOf(maxProfit, price - minPrice)
    }

    return maxProfit
}

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))    // 5
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))       // 0
}
