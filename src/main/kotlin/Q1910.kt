/**
 * 1910. Remove All Occurrences of a Substring
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring
 */

private fun removeOccurrences(s: String, part: String): String {
    var answer = s
    while (answer.contains(part)) {
        answer = answer.replaceFirst(part, "")
    }
    return answer
}

fun main() {
    println(removeOccurrences("daabcbaabcbc", "abc")) // "dab"
    println(removeOccurrences("axxxxyyyyb", "xy")) // "ab"
}