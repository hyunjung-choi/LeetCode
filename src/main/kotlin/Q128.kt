/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */

private fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    val sortedNums = nums.sorted()
    var maxLength = 1
    var currentLength = 1

    for (i in 1 until sortedNums.size) {
        when {
            sortedNums[i] == sortedNums[i - 1] -> continue
            sortedNums[i] == sortedNums[i - 1] + 1 -> {
                currentLength++
                maxLength = maxOf(maxLength, currentLength)
            }

            else -> currentLength = 1
        }
    }

    return maxLength
}

fun main() {
    println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    println(longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
    println(longestConsecutive(intArrayOf(1, 0, 1, 2)))
}
