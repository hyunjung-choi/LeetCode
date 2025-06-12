import kotlin.math.abs

/**
 * 3423. Maximum Difference Between Adjacent Elements in a Circular Array
 * https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array
 */

private fun maxAdjacentDistance(nums: IntArray): Int {
    var maxDiff = abs(nums[0] - nums[nums.size - 1])

    for (i in 0 until nums.size - 1) {
        maxDiff = maxOf(maxDiff, abs(nums[i + 1] - nums[i]))
    }

    return maxDiff
}

fun main() {
    // Test case 1
    val nums1 = intArrayOf(1, 2, 4)
    println("Input: ${nums1.contentToString()}")
    println("Output: ${maxAdjacentDistance(nums1)}")
    println("Expected: 3")
    println()

    // Test case 2
    val nums2 = intArrayOf(-5, -10, -5)
    println("Input: ${nums2.contentToString()}")
    println("Output: ${maxAdjacentDistance(nums2)}")
    println("Expected: 5")
    println()

    // Additional test case
    val nums3 = intArrayOf(1, 3)
    println("Input: ${nums3.contentToString()}")
    println("Output: ${maxAdjacentDistance(nums3)}")
    println("Expected: 2")
}
