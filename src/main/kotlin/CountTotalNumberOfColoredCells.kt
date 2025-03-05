/**
 * 2579. Count Total Number of Colored Cells
 * https://leetcode.com/problems/count-total-number-of-colored-cells
 */

private fun coloredCells(n: Int): Long {
    if (n == 1) return 1
    return coloredCells(n - 1) + 4 * (n - 1)
}

fun main() {
    println(coloredCells(1))
    println(coloredCells(2))
    println(coloredCells(3))
    println(coloredCells(4))
}