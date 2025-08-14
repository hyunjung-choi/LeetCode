/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search
 */

private fun exist(board: Array<CharArray>, word: String): Boolean {
    if (word.isEmpty()) return true

    val rows = board.size
    val cols = board.firstOrNull()?.size ?: return false
    val visited = Array(rows) { BooleanArray(cols) }
    val directions = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

    fun dfs(r: Int, c: Int, index: Int): Boolean {
        if (index == word.length) return true
        if (r !in 0 until rows || c !in 0 until cols) return false
        if (visited[r][c] || board[r][c] != word[index]) return false

        visited[r][c] = true
        val found = directions.any { (dr, dc) -> dfs(r + dr, c + dc, index + 1) }
        visited[r][c] = false
        return found
    }

    return board.indices.any { r ->
        board[0].indices.any { c ->
            board[r][c] == word[0] && dfs(r, c, 0)
        }
    }
}

fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )

    println(exist(board, "ABCCED"))    // true
    println(exist(board, "SEE"))       // true
    println(exist(board, "ABCB"))      // false
}
