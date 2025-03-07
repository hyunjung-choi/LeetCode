/**
 * 2965. Find Missing and Repeated Values
 * https://leetcode.com/problems/find-missing-and-repeated-values
 */

private fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val n = grid.size
    val n2 = n * n

    val frequency = IntArray(n2 + 1)

    for (row in grid) {
        for (num in row) {
            frequency[num]++
        }
    }

    var repeating = -1
    var missing = -1

    for (i in 1..n2) {
        when {
            frequency[i] == 2 -> repeating = i
            frequency[i] == 0 -> missing = i
        }
    }

    return intArrayOf(repeating, missing)
}

fun main() {
    println(findMissingAndRepeatedValues(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2))).contentToString())  // [2, 4]
    println(
        findMissingAndRepeatedValues(
            arrayOf(
                intArrayOf(9, 1, 7),
                intArrayOf(8, 9, 2),
                intArrayOf(3, 4, 6)
            )
        ).contentToString()
    )  // [9, 5]
}