/**
 * 1399. Count Largest Group
 * https://leetcode.com/problems/count-largest-group
 */

private fun countLargestGroup(n: Int): Int {
    val groups = mutableMapOf<Int, Int>()

    for (i in 1..n) {
        val digitSum = getDigitSum(i)
        groups[digitSum] = groups.getOrDefault(digitSum, 0) + 1
    }

    val maxSize = groups.values.maxOrNull() ?: 0

    return groups.values.count { it == maxSize }
}

private fun getDigitSum(num: Int): Int {
    var sum = 0
    var n = num

    while (n > 0) {
        sum += n % 10
        n /= 10
    }

    return sum
}

fun main() {
    println(countLargestGroup(13))  // 4
    println(countLargestGroup(2))   // 2
    println(countLargestGroup(15))  // 6
}

