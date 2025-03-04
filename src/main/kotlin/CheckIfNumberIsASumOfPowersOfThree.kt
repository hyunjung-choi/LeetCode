/**
 * 1780. Check if Number is a Sum of Powers of Three
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three
 */

private fun checkPowersOfThree(n: Int): Boolean {
    var num = n

    while (num > 0) {
        if (num % 3 == 2) return false
        num /= 3
    }

    return true
}

fun main() {
    println(checkPowersOfThree(12)) // true
    println(checkPowersOfThree(91)) // true
    println(checkPowersOfThree(21)) // false
}