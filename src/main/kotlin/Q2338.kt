/**
 * 2338. Count the Number of Ideal Arrays
 * https://leetcode.com/problems/count-the-number-of-ideal-arrays
 */

const val MOD = 1_000_000_007
const val MAX = 10_001

private fun idealArrays(n: Int, maxValue: Int): Int {
    val count = Array(MAX) { IntArray(15) } // count[val][length] = val로 끝나는 length짜리 수열 수
    for (i in 1..maxValue) count[i][1] = 1

    for (length in 2..14) {
        for (i in 1..maxValue) {
            var j = 2 * i
            while (j <= maxValue) {
                count[j][length] = (count[j][length] + count[i][length - 1]) % MOD
                j += i
            }
        }
    }

    val comb = Array(n + 1) { LongArray(15) }
    for (i in 0..n) {
        comb[i][0] = 1
        for (j in 1..minOf(14, i)) {
            comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD
        }
    }

    var result = 0L
    for (valEnd in 1..maxValue) {
        for (length in 1..14) {
            if (count[valEnd][length] == 0) continue
            result = (result + comb[n - 1][length - 1] * count[valEnd][length]) % MOD
        }
    }

    return result.toInt()
}

fun main() {
    println(idealArrays(2, 5)) // 10
    println(idealArrays(5, 3)) // 11
}