/**
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say
 */

private fun countAndSay(n: Int): String {
    var result = "1"

    for (i in 2..n) {
        var temp = ""
        var count = 1

        for (j in 1 until result.length) {
            if (result[j] == result[j - 1]) {
                count++
            } else {
                temp += "$count${result[j - 1]}"
                count = 1
            }
        }
        temp += "$count${result[result.length - 1]}"
        result = temp
    }
    return result
}

fun main() {
    println(countAndSay(4)) // 1211
    println(countAndSay(1))  // 1
}