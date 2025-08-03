import java.util.Locale.getDefault

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome
 */

private fun isPalindrome(s: String): Boolean {
    if (s.isBlank()) return true
    val cleanedString = s.trim().filter { it.isLetterOrDigit() }.lowercase(getDefault())
    return cleanedString == cleanedString.reversed()
}

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome(" "))
}
