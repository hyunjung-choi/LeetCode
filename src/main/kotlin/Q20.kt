import java.util.Stack

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */

private fun isValid(s: String): Boolean {
    if (s.length % 2 == 1) return false

    val stack = Stack<Char>()
    val pairs = mapOf(')' to '(', ']' to '[', '}' to '{')

    for (char in s) {
        when {
            char in pairs -> {
                if (stack.isEmpty() || stack.pop() != pairs[char]) {
                    return false
                }
            }

            else -> stack.push(char)
        }
    }

    return stack.isEmpty()
}

fun main() {
    println(isValid("()"))      // true
    println(isValid("()[]{}"))  // true
    println(isValid("(]"))      // false
    println(isValid("([])"))    // true
    println(isValid("([)]"))    // false
}
