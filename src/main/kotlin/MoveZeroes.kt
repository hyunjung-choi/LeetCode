/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes
 */

private fun moveZeroes(nums: IntArray) {
    var index = 0

    nums.forEachIndexed { i, num ->
        if (num != 0) {
            nums[index] = nums[i]
            index++
        }
    }

    while (index < nums.size) {
        nums[index] = 0
        index++
    }
}

fun main() {
    println(moveZeroes(intArrayOf(0, 1, 0, 3, 12)))
    println(moveZeroes(intArrayOf(0)))
}