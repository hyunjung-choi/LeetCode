/**
 * 2145. Count the Hidden Sequences
 * https://leetcode.com/problems/count-the-hidden-sequences
 */

private fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
    var minPrefix = 0L
    var maxPrefix = 0L
    var prefix = 0L

    for (d in differences) {
        prefix += d
        minPrefix = minOf(minPrefix, prefix)
        maxPrefix = maxOf(maxPrefix, prefix)
    }

    val minStart = lower - minPrefix
    val maxStart = upper - maxPrefix

    val count = maxStart - minStart + 1
    return if (count >= 0) count.toInt() else 0
}

fun main() {
    println(numberOfArrays(intArrayOf(1, -3, 4), 1, 6))         // 2
    println(numberOfArrays(intArrayOf(3, -4, 5, 1, -2), -4, 5)) // 4
    println(numberOfArrays(intArrayOf(4, -7, 2), 3, 6))         // 0
}