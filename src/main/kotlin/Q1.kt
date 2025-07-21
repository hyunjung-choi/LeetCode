/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum
 */

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                result[0] = i
                result[1] = j
            }
        }
    }

    return result
}

fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString())
    println(twoSum(intArrayOf(3, 2, 4), 6).joinToString())
    println(twoSum(intArrayOf(3, 3), 6).joinToString())
}
