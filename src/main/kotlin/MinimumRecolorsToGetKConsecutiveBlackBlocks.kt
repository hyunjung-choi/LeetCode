/**
 * 2379. Minimum Recolors to Get K Consecutive Black Blocks
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 */

private fun minimumRecolors(blocks: String, k: Int): Int {
    var minOperations: Int

    var whiteCount = 0
    for (i in 0 until k) {
        if (blocks[i] == 'W') whiteCount++
    }

    minOperations = whiteCount

    for (i in k until blocks.length) {
        if (blocks[i - k] == 'W') whiteCount--
        if (blocks[i] == 'W') whiteCount++

        minOperations = minOf(minOperations, whiteCount)
    }

    return minOperations
}

fun main() {
    println(minimumRecolors("WBBWWBBWBW", 7))   // 3
    println(minimumRecolors("WBWBBBW", 2))      // 0
}