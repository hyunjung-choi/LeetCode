/*
191. Number of 1 Bits
https://leetcode.com/problems/number-of-1-bits
 */

private fun hammingWeight(n: Int) = Integer.bitCount(n)

fun main() {
    println(hammingWeight(11))          // 3
    println(hammingWeight(128))         // 1
    println(hammingWeight(2147483645))  // 30
}
