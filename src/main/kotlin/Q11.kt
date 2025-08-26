/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */

private fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.size - 1
    var max = 0

    while (i < j) {
        val h = minOf(height[i], height[j])
        max = maxOf(max, (j - i) * h)

        if (height[i] <= height[j]) i++
        else j--
    }

    return max
}

fun main() {
    println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))) // 49
    println(maxArea(intArrayOf(1, 1)))              // 1
}
