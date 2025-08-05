/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum
 */

private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val currentCombination = mutableListOf<Int>()

    candidates.sort()

    backtrack(candidates, target, 0, currentCombination, result)

    return result
}

private fun backtrack(
    candidates: IntArray,
    remainingTarget: Int,
    startIndex: Int,
    currentCombination: MutableList<Int>,
    result: MutableList<List<Int>>
) {
    if (remainingTarget == 0) {
        result.add(currentCombination.toList())
        return
    }

    if (remainingTarget < 0) {
        return
    }

    for (i in startIndex until candidates.size) {
        val candidate = candidates[i]

        if (candidate > remainingTarget) {
            break
        }

        currentCombination.add(candidate)

        backtrack(candidates, remainingTarget - candidate, i, currentCombination, result)

        currentCombination.removeAt(currentCombination.size - 1)
    }
}

fun main() {
    println(combinationSum(intArrayOf(2, 3, 6, 7), 7))  // [[2,2,3],[7]]
    println(combinationSum(intArrayOf(2, 3, 5), 8))     // [[2,2,2,2],[2,3,3],[3,5]]
    println(combinationSum(intArrayOf(2), 1))           // []
}
