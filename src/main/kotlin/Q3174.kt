/**
 * 3174. Clear Digits
 * https://leetcode.com/problems/clear-digits?envType=daily-question&envId=2025-02-10
 */

private fun clearDigits(s: String): String {
    val stack = ArrayDeque<Char>()

    for (ch in s) {
        if (ch.isDigit()) {
            if (stack.isNotEmpty()) {
                stack.removeLast()
            }
        } else {
            stack.addLast(ch)
        }
    }

    return stack.joinToString("")
}

fun main() {
    println(clearDigits("abc"))   // "abc"
    println(clearDigits("cb34"))  // ""
    println(clearDigits("a1b2c3")) // ""
    println(clearDigits("a2b3c4d5")) // ""
    println(clearDigits("abcd1234")) // ""
    println(clearDigits("z2x3c4v5")) // ""
}