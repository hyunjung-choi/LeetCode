/**
 * 2799. Count Complete Subarrays in an Array
 * https://leetcode.com/problems/count-complete-subarrays-in-an-array
 */

private fun countCompleteSubarrays(nums: IntArray): Int {
    val n = nums.size
    val totalDistinct = nums.toSet().size
    var count = 0
    val freq = mutableMapOf<Int, Int>()
    var left = 0

    for (right in 0 until n) {
        freq[nums[right]] = freq.getOrDefault(nums[right], 0) + 1

        while (freq.size == totalDistinct) {
            freq[nums[left]] = freq[nums[left]]!! - 1
            if (freq[nums[left]] == 0) {
                freq.remove(nums[left])
            }
            count += n - right
            left++
        }
    }

    return count
}

fun main() {
    println(countCompleteSubarrays(intArrayOf(1, 3, 1, 2, 2)))  // 4
    println(countCompleteSubarrays(intArrayOf(5, 5, 5, 5)))     // 10
}