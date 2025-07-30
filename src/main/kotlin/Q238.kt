/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 */

private fun productExceptSelf(nums: IntArray): IntArray =
    IntArray(nums.size) { 1 }.apply {
        var leftProduct = 1
        for (i in 1 until nums.size) {
            leftProduct *= nums[i - 1]
            this[i] = leftProduct
        }

        var rightProduct = 1
        for (i in nums.size - 2 downTo 0) {
            rightProduct *= nums[i + 1]
            this[i] *= rightProduct
        }
    }

fun main() {
    println(productExceptSelf(intArrayOf(1, 2, 3, 4)).joinToString())       // 24, 12, 8, 6
    println(productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).joinToString()) // 0, 0, 9, 0, 0
}
