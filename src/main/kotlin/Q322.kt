/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change
 */

private fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { Int.MAX_VALUE }
    dp[0] = 0

    for (i in 1..amount) {
        for (coin in coins) {
            if (i - coin >= 0 && dp[i - coin] != Int.MAX_VALUE) {
                dp[i] = minOf(dp[i], dp[i - coin] + 1)
            }
        }
    }

    return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
}

fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11)) // 3
    println(coinChange(intArrayOf(2), 3)) // -1
    println(coinChange(intArrayOf(1), 0)) // 0
}
