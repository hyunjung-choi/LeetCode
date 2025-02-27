import java.util.*

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 */

private fun findKthLargest(nums: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int>()

    for (num in nums) {
        pq.offer(num)
        if (pq.size > k) pq.poll()
    }

    return pq.peek()
}

fun main() {
    println(findKthLargest(intArrayOf(2, 3, 1, 5, 6, 4), 2))
    println(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}