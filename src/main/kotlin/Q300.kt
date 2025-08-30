/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */

private fun lengthOfLIS(nums: IntArray): Int {
    val tails = mutableListOf<Int>()

    for (num in nums) {
        val pos = binarySearchLeftmost(tails, num)

        if (pos == tails.size) {
            tails.add(num)
        } else {
            tails[pos] = num
        }
    }

    return tails.size
}

private fun binarySearchLeftmost(list: List<Int>, target: Int): Int {
    var left = 0
    var right = list.size

    while (left < right) {
        val mid = left + (right - left) / 2
        if (list[mid] < target) {
            left = mid + 1
        } else {
            right = mid
        }
    }

    return left
}

fun main() {
    println(lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))) // 4
    println(lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))          // 4
    println(lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7)))       // 1
    println(lengthOfLIS(intArrayOf(4, 10, 4, 3, 8, 9)))         // 3
}
