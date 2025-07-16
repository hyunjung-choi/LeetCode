/**
 * 3201. Find the Maximum Length of Valid Subsequence I
 * https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i
 */

fun maximumLength(nums: IntArray): Int {
    var allEven = 0
    var allOdd = 0

    for (num in nums) {
        if (num % 2 == 0) {
            allEven++
        } else {
            allOdd++
        }
    }

    var alternatingEvenFirst = 0
    var expectingEven = true

    for (num in nums) {
        val isEven = num % 2 == 0
        if (isEven == expectingEven) {
            alternatingEvenFirst++
            expectingEven = !expectingEven
        }
    }

    var alternatingOddFirst = 0
    var expectingOdd = true

    for (num in nums) {
        val isOdd = num % 2 == 1
        if (isOdd == expectingOdd) {
            alternatingOddFirst++
            expectingOdd = !expectingOdd
        }
    }

    return maxOf(allEven, allOdd, alternatingEvenFirst, alternatingOddFirst)
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 4)
    println("Input: ${nums1.contentToString()}")
    println("Output: ${maximumLength(nums1)}")  // 4
    println()

    val nums2 = intArrayOf(1, 2, 1, 1, 2, 1, 2)
    println("Input: ${nums2.contentToString()}")
    println("Output: ${maximumLength(nums2)}")  // 6
    println()

    val nums3 = intArrayOf(1, 3)
    println("Input: ${nums3.contentToString()}")
    println("Output: ${maximumLength(nums3)}")  // 2
}
