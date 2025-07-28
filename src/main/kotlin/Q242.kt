/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */

private fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val charCount = mutableMapOf<Char, Int>()

    s.forEach { ch ->
        charCount.put(ch, charCount.getOrDefault(ch, 0) + 1)
    }

    t.forEach { ch ->
        val count = charCount.getOrDefault(ch, 0)
        if (count == 0) return false
        charCount[ch] = count - 1
    }

    return true
}


fun main() {
    println(isAnagram("anagram", "nagaram"))    // true
    println(isAnagram("rat", "car"))            // false
    println(isAnagram("café", "éfac"))          // true
}
