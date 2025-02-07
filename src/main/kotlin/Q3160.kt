/**
 * 3160. Find the Number of Distinct Colors Among the Balls
 * https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls
 */

private fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
    val ballColors = mutableMapOf<Int, Int>()
    val colorCountMap = mutableMapOf<Int, Int>()
    val result = IntArray(queries.size)

    for (i in queries.indices) {
        val ballIndex = queries[i][0]
        val newColor = queries[i][1]

        if (ballIndex in ballColors) {
            val oldColor = ballColors[ballIndex]!!

            colorCountMap[oldColor] = colorCountMap[oldColor]!! - 1

            if (colorCountMap[oldColor] == 0) {
                colorCountMap.remove(oldColor)
            }
        }

        ballColors[ballIndex] = newColor
        colorCountMap[newColor] = colorCountMap.getOrDefault(newColor, 0) + 1

        result[i] = colorCountMap.size
    }

    return result
}

fun main() {
    val limit1 = 4
    val queries1 = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(2, 5),
        intArrayOf(1, 3),
        intArrayOf(3, 4)
    )
    println("Example 1:")
    println("Input: limit = $limit1, queries = ${queries1.contentDeepToString()}")
    println("Output: ${queryResults(limit1, queries1).contentToString()}")  // 예상 출력: [1,2,2,3]

    val limit2 = 4
    val queries2 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(2, 2),
        intArrayOf(3, 4),
        intArrayOf(4, 5)
    )
    println("\nExample 2:")
    println("Input: limit = $limit2, queries = ${queries2.contentDeepToString()}")
    println("Output: ${queryResults(limit2, queries2).contentToString()}")  // 예상 출력: [1,2,2,3,4]
}