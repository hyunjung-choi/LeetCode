/**
 * 2140. Solving Questions With Brainpower
 * https://leetcode.com/problems/solving-questions-with-brainpower
 */

private fun mostPoints(questions: Array<IntArray>): Long {
    val n = questions.size
    val dp = LongArray(n + 1) { 0 }

    for (i in n - 1 downTo 0) {
        val points = questions[i][0]
        val brainpower = questions[i][1]

        val nextIndex = minOf(i + brainpower + 1, n)

        dp[i] = maxOf(points + dp[nextIndex], dp[i + 1])
    }

    return dp[0]
}

fun main() {
    println(
        mostPoints(
            arrayOf(
                intArrayOf(3, 2),
                intArrayOf(4, 3),
                intArrayOf(4, 4),
                intArrayOf(2, 5)
            )
        )
    )   // 5
    println(
        mostPoints(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(3, 3),
                intArrayOf(4, 4),
                intArrayOf(5, 5)
            )
        )
    )  // 7
}