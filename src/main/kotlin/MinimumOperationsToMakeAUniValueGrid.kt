import kotlin.math.abs

/**
 * 2033. Minimum Operations to Make a Uni-Value Grid
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid
 */

private fun minOperations(grid: Array<IntArray>, x: Int): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return -1

    val m = grid.size
    val n = grid[0].size
    val total = m * n

    val elements = grid.flatMap { it.toList() }.toIntArray()

    val remainder = elements[0] % x

    for (element in elements) {
        if (element % x != remainder) return -1
    }

    elements.sort()

    val target = elements[total / 2]

    var operations = 0
    for (element in elements) {
        operations += abs(element - target) / x
    }

    return operations
}

fun main() {
    println(minOperations(arrayOf(intArrayOf(2, 4), intArrayOf(6, 8)), 2))  // 4
    println(minOperations(arrayOf(intArrayOf(1, 5), intArrayOf(2, 3)), 1))  // 5
    println(minOperations(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 2))  // -1
}