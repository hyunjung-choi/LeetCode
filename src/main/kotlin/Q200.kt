/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */

private fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val row = grid.size
    val column = grid[0].size
    var isIslandCount = 0

    for (i in 0 until row) {
        for (j in 0 until column) {
            if (grid[i][j] == '1') {
                isIslandCount++
                dfs(grid, i, j, row, column)
            }
        }
    }

    return isIslandCount
}

private fun dfs(grid: Array<CharArray>, i: Int, j: Int, row: Int, column: Int) {
    if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != '1') {
        return
    }

    grid[i][j] = '0'

    dfs(grid, i - 1, j, row, column)
    dfs(grid, i + 1, j, row, column)
    dfs(grid, i, j - 1, row, column)
    dfs(grid, i, j + 1, row, column)
}

fun main() {
    println(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        )
    ) // 1

    println(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        )
    ) // 3
}
