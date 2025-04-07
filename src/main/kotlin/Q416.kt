/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum
 */

private fun canPartition(nums: IntArray): Boolean {
    val sum = nums.sum()

    if (sum % 2 != 0) return false

    val target = sum / 2

    val dp = BooleanArray(target + 1)
    dp[0] = true

    for (num in nums) {
        for (j in target downTo num) {
            dp[j] = dp[j] || dp[j - num]
        }
    }

    return dp[target]
}

fun main() {
    println(canPartition(intArrayOf(1, 5, 11, 5)))  // true
    println(canPartition(intArrayOf(1, 2, 3, 5)))   // false
}