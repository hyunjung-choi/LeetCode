import kotlin.math.abs

/**
 * 1534. Count Good Triplets
 * https://leetcode.com/problems/count-good-triplets
 */

private fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    var count = 0
    val n = arr.size

    for (j in 0 until n - 1) {
        val iSet = mutableListOf<Int>()
        for (i in 0 until j) {
            if (abs(arr[i] - arr[j]) <= a) iSet.add(i)
        }

        val kSet = mutableListOf<Int>()
        for (k in j + 1 until n) {
            if (abs(arr[j] - arr[k]) <= b) kSet.add(k)
        }

        for (i in iSet) {
            for (k in kSet) {
                if (abs(arr[i] - arr[k]) <= c) count++
            }
        }
    }

    return count
}

fun main() {
    println(countGoodTriplets(intArrayOf(3, 0, 1, 1, 9, 7), 7, 2, 3))   // 4
    println(countGoodTriplets(intArrayOf(1, 1, 2, 2, 3), 0, 0, 1))      // 0
}