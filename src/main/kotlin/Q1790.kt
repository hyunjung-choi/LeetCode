/**
 * 1790. Check if One String Swap Can Make Strings Equal
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 */

private fun areAlmostEqual(s1: String, s2: String): Boolean =
    if (s1 == s2) true
    else {
        val diff = s1.zip(s2).filter { (a, b) -> a != b }
        diff.size == 2 && diff[0].first == diff[1].second && diff[0].second == diff[1].first
    }

fun main() {
    println(areAlmostEqual("bank", "kanb")) // true
    println(areAlmostEqual("attack", "defend")) // false
    println(areAlmostEqual("kelb", "kelb")) // true
}