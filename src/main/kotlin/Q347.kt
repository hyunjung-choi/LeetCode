/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val frequency = nums.toList().groupingBy { it }.eachCount()

    return frequency
        .toList()
        .sortedByDescending { it.second }
        .take(k)
        .map { it.first }
        .toIntArray()
}

fun main() {
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).joinToString())  // [1, 2]
    println(topKFrequent(intArrayOf(1), 1).joinToString())                 // [1]
}
