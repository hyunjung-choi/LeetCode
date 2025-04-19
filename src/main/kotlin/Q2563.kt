/**
 * 2563. Count the Number of Fair Pairs
 * https://leetcode.com/problems/count-the-number-of-fair-pairs
 */

private fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
    nums.sort()
    var count = 0L

    for (i in nums.indices) {
        val minTarget = lower - nums[i]
        val maxTarget = upper - nums[i]

        val left = lowerBound(nums, i + 1, nums.size, minTarget)
        val right = upperBound(nums, i + 1, nums.size, maxTarget)

        count += (right - left)
    }

    return count
}

private fun lowerBound(arr: IntArray, from: Int, to: Int, target: Int): Int {
    var low = from
    var high = to
    while (low < high) {
        val mid = (low + high) / 2
        if (arr[mid] < target) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
}

private fun upperBound(arr: IntArray, from: Int, to: Int, target: Int): Int {
    var low = from
    var high = to
    while (low < high) {
        val mid = (low + high) / 2
        if (arr[mid] <= target) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
}

fun main() {
    println(countFairPairs(intArrayOf(0, 1, 7, 4, 4, 5), 3, 6)) // 6
    println(countFairPairs(intArrayOf(1, 7, 9, 2, 5), 11, 11))  // 1
}