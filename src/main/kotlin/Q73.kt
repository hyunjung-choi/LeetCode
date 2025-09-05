/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 */

private fun setZeroes(matrix: Array<IntArray>) {
    val m = matrix.size
    val n = matrix[0].size

    var firstRowHasZero = false
    var firstColumnHasZero = false

    for (j in 0 until n) {
        if (matrix[0][j] == 0) {
            firstRowHasZero = true
            break
        }
    }

    for (i in 0 until m) {
        if (matrix[i][0] == 0) {
            firstColumnHasZero = true
            break
        }
    }

    for (i in 1 until m) {
        for (j in 1 until n) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }

    for (i in 1 until m) {
        for (j in 1 until n) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0
            }
        }
    }

    for (j in 0 until n) {
        if (firstRowHasZero) {
            matrix[0][j] = 0
        }
    }

    for (i in 0 until m) {
        if (firstColumnHasZero) {
            matrix[i][0] = 0
        }
    }
}

fun main() {
    val matrix1 = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1)
    )
    setZeroes(matrix1)
    println(matrix1.contentDeepToString()) // [[1,0,1],[0,0,0],[1,0,1]]

    val matrix2 = arrayOf(
        intArrayOf(0, 1, 2, 0),
        intArrayOf(3, 4, 5, 2),
        intArrayOf(1, 3, 1, 5)
    )
    setZeroes(matrix2)
    println(matrix2.contentDeepToString()) // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
}
