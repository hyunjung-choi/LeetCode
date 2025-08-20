/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 */

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val groupMap = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        val sortedKey = str.toCharArray().sorted().joinToString("")
        groupMap.getOrPut(sortedKey) { mutableListOf()}.add(str)
    }

    return groupMap.values.toList()
}

fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))   // [["bat"],["nat","tan"],["ate","eat","tea"]]
    println(groupAnagrams(arrayOf("")))                                         // [[""]]
    println(groupAnagrams(arrayOf("a")))                                        // [["a"]]
}
