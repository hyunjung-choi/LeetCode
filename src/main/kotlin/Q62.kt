/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 */

private fun uniquePaths(m: Int, n: Int): Int {
    val dp = IntArray(n) { 1 }

    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[j] += dp[j - 1]
        }
    }

    return dp[n - 1]
}

fun main() {
    println(uniquePaths(3, 7)) // 28
    println(uniquePaths(3, 2)) // 3
}
