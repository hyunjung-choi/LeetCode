/**
 * 2529. Maximum Count of Positive Integer and Negative Integer
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer
 */

private fun maximumCount(nums: IntArray): Int {
    nums.filter { it > 0 }.let { positive ->
        nums.filter { it < 0 }.let { negative ->
            return if (positive.size > negative.size) positive.size else negative.size
        }
    }
}

fun main() {
    println(maximumCount(intArrayOf(-2, -1, -1, 1, 2, 3)))      // 3
    println(maximumCount(intArrayOf(-3, -2, -1, 0, 0, 1, 2)))   // 3
    println(maximumCount(intArrayOf(5, 20, 66, 1314)))          // 4
}