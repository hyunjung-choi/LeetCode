/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs
 */

private fun climbStairs(n: Int): Int {
    if (n <= 2) return n

    var prev2 = 1
    var prev1 = 2

    for (i in 3..n) {
        val current = prev1 + prev2
        prev2 = prev1
        prev1 = current
    }

    return prev1
}

fun main() {
    println(climbStairs(2)) // 2
    println(climbStairs(3)) // 3
}
