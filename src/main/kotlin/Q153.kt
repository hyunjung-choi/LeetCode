/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 */

private fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val mid = left + (right - left) / 2

        if (nums[mid] > nums[right]) {
            left = mid + 1
        } else {
            right = mid
        }
    }

    return nums[left]
}

fun main() {
    val testCases = arrayOf(
        intArrayOf(3, 4, 5, 1, 2),          // 1
        intArrayOf(4, 5, 6, 7, 0, 1, 2),    // 0
        intArrayOf(11, 13, 15, 17),         // 11
        intArrayOf(1),                      // 1
        intArrayOf(2, 1),                   // 1
        intArrayOf(1, 2, 3, 4, 5)           // 1
    )

    testCases.forEach {
        println(findMin(it))
    }
}
