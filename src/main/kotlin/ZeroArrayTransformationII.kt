/**
 * 3356. Zero Array Transformation II
 * https://leetcode.com/problems/zero-array-transformation-ii
 */

private fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
    if (nums.all { it == 0 }) return 0

    val q = queries.size

    if (!canFormZeroArray(nums, queries, q)) return -1

    var left = 0
    var right = q

    while (left < right) {
        val mid = left + (right - left) / 2

        if (canFormZeroArray(nums, queries, mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
}

private fun canFormZeroArray(nums: IntArray, queries: Array<IntArray>, k: Int): Boolean {
    val n = nums.size
    val diffArray = IntArray(n + 1)

    for (i in 0 until k) {
        val (start, end, value) = queries[i]
        diffArray[start] += value
        diffArray[end + 1] -= value
    }

    var sum = 0
    for (i in 0 until n) {
        sum += diffArray[i]
        if (sum < nums[i]) {
            return false
        }
    }

    return true
}

fun main() {
    println(
        minZeroArray(
            intArrayOf(2, 0, 2),
            arrayOf(intArrayOf(0, 2, 1), intArrayOf(0, 2, 1), intArrayOf(1, 1, 3))
        )
    ) // 2
    println(minZeroArray(intArrayOf(4, 3, 2, 1), arrayOf(intArrayOf(1, 3, 2), intArrayOf(0, 2, 1)))) // -1
    println(
        minZeroArray(
            intArrayOf(0),
            arrayOf(
                intArrayOf(0, 0, 2),
                intArrayOf(0, 0, 4),
                intArrayOf(0, 0, 4),
                intArrayOf(0, 0, 3),
                intArrayOf(0, 0, 5)
            )
        )
    ) // 0
}