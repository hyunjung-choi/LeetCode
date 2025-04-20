/**
 * 781. Rabbits in Forest
 * https://leetcode.com/problems/rabbits-in-forest
 */

private fun numRabbits(answers: IntArray): Int {
    val frequency = mutableMapOf<Int, Int>()
    var result = 0

    for (answer in answers) {
        frequency[answer] = frequency.getOrDefault(answer, 0) + 1
    }

    println(frequency.toString())

    for ((x, count) in frequency) {
        val groupSize = x + 1
        val groups = (count + groupSize - 1) / groupSize
        result += groups * groupSize
    }

    return result
}

fun main() {
    println(numRabbits(intArrayOf(1, 1, 2)))     // 5
    println(numRabbits(intArrayOf(10, 10, 10)))  // 11
}