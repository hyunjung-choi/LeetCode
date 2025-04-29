/**
 * 2962. Count Subarrays Where Max Element Appears at Least K Times
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times
 */

private fun countSubarrays(nums: IntArray, k: Int): Long {
    val max = nums.maxOrNull() ?: 0
    var count = 0L
    var left = 0
    var result = 0L

    for (right in nums.indices) {
        if (nums[right] == max) count++

        while (count >= k) {
            if (nums[left] == max) count--
            left++
        }

        result += left
    }

    return result
}

fun main() {
    println(countSubarrays(intArrayOf(1, 3, 2, 3, 3), 2))   // 6
    println(countSubarrays(intArrayOf(1, 4, 2, 1), 3))      // 0
}