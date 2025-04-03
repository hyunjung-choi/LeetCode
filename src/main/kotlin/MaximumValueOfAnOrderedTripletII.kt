/**
 * 2874. Maximum Value of an Ordered Triplet II
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii
 */

private fun maximumTripletValue(nums: IntArray): Long {
    val n = nums.size
    var maxValue: Long = 0

    var maxDiff = 0
    var maxNum = 0

    for (i in 0 until n) {
        val value = maxDiff.toLong() * nums[i].toLong()
        maxValue = maxOf(maxValue, value)

        maxDiff = maxOf(maxDiff, maxNum - nums[i])

        maxNum = maxOf(maxNum, nums[i])
    }

    return maxValue
}

fun main() {
    println(maximumTripletValue(intArrayOf(12, 6, 1, 2, 7)))    // 77
    println(maximumTripletValue(intArrayOf(1, 10, 3, 4, 19)))   // 133
    println(maximumTripletValue(intArrayOf(1, 2, 3)))           // 0
}