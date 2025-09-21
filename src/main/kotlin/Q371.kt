/**
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/
 */

private fun getSum(a: Int, b: Int): Int {
    var numA = a
    var numB = b

    while (numB != 0) {
        val carry = numA and numB
        numA = numA xor numB
        numB = carry shl 1
    }

    return numA
}

fun main() {
    println(getSum(1, 2))       // 3
    println(getSum(2, 3))       // 5
    println(getSum(-1, 1))      // 0
    println(getSum(-2, 3))      // 1
    println(getSum(-3, -4))     // -7
    println(getSum(0, 0))       // 0
    println(getSum(123, 456))   // 579
}
