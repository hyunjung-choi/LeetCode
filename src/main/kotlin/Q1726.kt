/**
 * 1726. Tuple with Same Product
 * https://leetcode.com/problems/tuple-with-same-product
 */

private fun tupleSameProduct(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            val prod = nums[i] * nums[j]
            map[prod] = map.getOrDefault(prod, 0) + 1
        }
    }

    var answer = 0

    for (count in map.values) {
        if (count > 1) {
            answer += count * (count - 1) * 4
        }
    }

    return answer
}

fun main() {
    val nums1 = intArrayOf(2, 3, 4, 6)
    println("Input: ${nums1.contentToString()}, Output: ${tupleSameProduct(nums1)}")  // 8

    val nums2 = intArrayOf(1, 2, 4, 5, 10)
    println("Input: ${nums2.contentToString()}, Output: ${tupleSameProduct(nums2)}") // 16
}