/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray
 */

private fun maxSubArray(nums: IntArray): Int {
    var currentSum = nums[0]
    var maxSum = nums[0]

    for (i in 1 until nums.size) {
        currentSum = if (currentSum < 0) nums[i] else currentSum + nums[i]
        maxSum = maxOf(currentSum, maxSum)
    }

    return maxSum
}

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))) // 6
    println(maxSubArray(intArrayOf(1)))                             // 1
    println(maxSubArray(intArrayOf(5, 4, -1, 7, 8)))                // 23
}
