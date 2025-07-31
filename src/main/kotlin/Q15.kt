/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 */

private fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()

    val result = mutableSetOf<List<Int>>()

    nums.sort()

    for (i in 0 until nums.size - 2) {

        if (i > 0 && nums[i] == nums[i - 1]) continue

        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]

            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[left], nums[right]))

                    left++
                    right--
                }

                sum < 0 -> left++
                else -> right--
            }
        }
    }

    return result.toList()
}

fun main() {
    val testCases = arrayOf(
        intArrayOf(-1, 0, 1, 2, -1, -4),
        intArrayOf(0, 1, 1),
        intArrayOf(0, 0, 0),
        intArrayOf(-2, 0, 1, 1, 2),
        intArrayOf(-1, 0, 1)
    )

    testCases.forEachIndexed { index, nums ->
        println("Test case ${index + 1}: ${nums.contentToString()}")
        println("Result: ${threeSum(nums)}")
        println()
    }
}
