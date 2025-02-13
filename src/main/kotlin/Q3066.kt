import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * 3066. Minimum Operations to Exceed Threshold Value II
 * https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii
 */

private fun minOperations(nums: IntArray, k: Int): Int {
    val pq = PriorityQueue(nums.toList().map { it.toLong() })
    var operations = 0

    while (pq.peek() < k) {
        val x = pq.poll()
        val y = pq.poll()
        pq.offer(min(x, y) * 2 + max(x, y))
        operations++
    }

    return operations
}

fun main() {
    val nums1 = intArrayOf(2, 11, 10, 1, 3)
    val k1 = 10
    println(minOperations(nums1, k1))  // 출력: 2

    val nums2 = intArrayOf(1, 1, 2, 4, 9)
    val k2 = 20
    println(minOperations(nums2, k2))  // 출력: 4
}