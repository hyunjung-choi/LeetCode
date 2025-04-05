/**
 * 1863. Sum of All Subset XOR Totals
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals
 */

private fun subsetXORSum(nums: IntArray): Int {
    val n = nums.size
    var totalSum = 0

    for (mask in 0 until (1 shl n)) {
        var xorTotal = 0

        for (i in 0 until n) {
            if ((mask and (1 shl i)) != 0) {
                xorTotal = xorTotal xor nums[i]
            }
        }

        totalSum += xorTotal
    }

    return totalSum
}

fun main() {
    println(subsetXORSum(intArrayOf(1, 3)))             // 6
    println(subsetXORSum(intArrayOf(5, 1, 6)))          // 28
    println(subsetXORSum(intArrayOf(3, 4, 5, 6, 7, 8))) // 480
}