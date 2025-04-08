/**
 * 3396. Minimum Number of Operations to Make Elements in Array Distinct
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct
 */

private fun minOperationsToMakeDistinct(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var operations = 0
    var currentNums = nums.toList()

    while (currentNums.isNotEmpty()) {
        if (isDistinct(currentNums)) {
            return operations
        }

        val elementsToRemove = minOf(3, currentNums.size)
        currentNums = currentNums.drop(elementsToRemove)
        operations++
    }

    return operations
}

private fun isDistinct(nums: List<Int>): Boolean {
    val set = HashSet<Int>()
    for (num in nums) {
        if (!set.add(num)) {
            return false
        }
    }
    return true
}

fun main() {
    println(minOperationsToMakeDistinct(intArrayOf(1, 2, 3, 4, 2, 3, 3, 5, 7))) // 2
    println(minOperationsToMakeDistinct(intArrayOf(4, 5, 6, 4, 4)))             // 2
    println(minOperationsToMakeDistinct(intArrayOf(6, 7, 8, 9)))                // 0
    println(minOperationsToMakeDistinct(intArrayOf(4, 3)))                      // 0
}