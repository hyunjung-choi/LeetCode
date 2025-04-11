/**
 * 2843. Count Symmetric Integers
 * https://leetcode.com/problems/count-symmetric-integers
 */

private fun countSymmetricIntegers(low: Int, high: Int): Int {
    return (low..high)
        .asSequence()
        .filter { it.toString().length % 2 == 0 }
        .count { isSymmetric(it) }
}

private fun isSymmetric(num: Int): Boolean {
    val digits = num.toString()
    val halfLength = digits.length / 2

    val firstHalfSum = digits.take(halfLength).sumOf { it.digitToInt() }
    val secondHalfSum = digits.takeLast(halfLength).sumOf { it.digitToInt() }

    return firstHalfSum == secondHalfSum
}

fun main() {
    println(countSymmetricIntegers(1, 100))     // 9
    println(countSymmetricIntegers(1200, 1230)) // 4
}