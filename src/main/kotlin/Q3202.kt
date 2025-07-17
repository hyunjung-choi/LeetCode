/**
 * 3202. Find the Maximum Length of Valid Subsequence II
 * https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii
 */

private fun maximumLength(nums: IntArray, k: Int): Int {
    var maxLength = 0

    for (target in 0 until k) {
        val dp = IntArray(k)

        for (num in nums) {
            val remainder = num % k

            val prevRemainder = (target - remainder + k) % k

            dp[remainder] = maxOf(dp[remainder], dp[prevRemainder] + 1)
        }

        maxLength = maxOf(maxLength, dp.maxOrNull() ?: 0)
    }

    return maxLength
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 4, 5)
    val k1 = 2
    println("Example 1: ${maximumLength(nums1, k1)}") // 5

    val nums2 = intArrayOf(1, 4, 2, 3, 1, 4)
    val k2 = 3
    println("Example 2: ${maximumLength(nums2, k2)}") // 4

    val nums3 = intArrayOf(1, 2, 3, 4)
    val k3 = 4
    println("Example 3: ${maximumLength(nums3, k3)}") // 4
}
