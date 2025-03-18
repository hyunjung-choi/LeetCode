/**
 * 2206. Divide Array Into Equal Pairs
 * https://leetcode.com/problems/divide-array-into-equal-pairs
 */

private fun divideArray(nums: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()
    val list = nums.copyOf()

    for (num in list) {
        map.put(num, map.getOrDefault(num, 0) + 1)
    }

    map.values.forEach { n ->
        if (n % 2 != 0) return false
    }

    return true
}

fun main() {
    println(divideArray(intArrayOf(3, 2, 3, 2, 2, 2)))
    println(divideArray(intArrayOf(1, 2, 3, 4)))
}