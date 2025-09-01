/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

private fun lengthOfLongestSubstring(s: String): Int {
    val seen = mutableSetOf<Char>()
    var left = 0
    var maxLength = 0

    for (right in s.indices) {
        while (s[right] in seen) {
            seen.remove(s[left])
            left++
        }

        seen.add(s[right])
        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))   // 3
    println(lengthOfLongestSubstring("bbbbb"))      // 1
    println(lengthOfLongestSubstring("pwwkew"))     // 3
    println(lengthOfLongestSubstring(""))           // 0
    println(lengthOfLongestSubstring(" "))          // 1
    println(lengthOfLongestSubstring("au"))         // 2
    println(lengthOfLongestSubstring("dvdf"))       // 3
}
