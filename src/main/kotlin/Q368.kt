/**
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset
 */

private fun largestDivisibleSubset(nums: IntArray): List<Int> {
    if (nums.isEmpty()) return emptyList()

    nums.sort()

    val n = nums.size

    val dp = IntArray(n) { 1 }

    val prev = IntArray(n) { -1 }

    var maxSize = 1
    var maxIndex = 0

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1
                prev[i] = j
            }
        }

        if (dp[i] > maxSize) {
            maxSize = dp[i]
            maxIndex = i
        }
    }

    val result = mutableListOf<Int>()
    var index = maxIndex

    while (index != -1) {
        result.add(nums[index])
        index = prev[index]
    }

    result.reverse()

    return result
}

fun main() {
    println(largestDivisibleSubset(intArrayOf(1, 2, 3)))
    println(largestDivisibleSubset(intArrayOf(1, 2, 4, 8)))
}