/**
 * 2900. Longest Unequal Adjacent Groups Subsequence I
 * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i
 */

private fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
    if (words.isEmpty()) return emptyList()

    val result = mutableListOf<String>()
    result.add(words[0])
    var lastGroup = groups[0]

    for (i in 1 until words.size) {
        if (groups[i] != lastGroup) {
            result.add(words[i])
            lastGroup = groups[i]
        }
    }

    return result
}

fun main() {
    val example1 = getLongestSubsequence(arrayOf("e", "a", "b"), intArrayOf(0, 0, 1))
    println(example1)  // [e, b] or [a, b]

    val example2 = getLongestSubsequence(arrayOf("a", "b", "c", "d"), intArrayOf(1, 0, 1, 1))
    println(example2)  // [a, b, c] or [a, b, d]
}
