/**
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */

class WordDictionary() {

    class TrieNode {
        val children = mutableMapOf<Char, TrieNode>()
        var isEndOfWord = false
    }

    private val root = TrieNode()

    fun addWord(word: String) {
        var current = root

        for (char in word) {
            if (char !in current.children) {
                current.children[char] = TrieNode()
            }
            current = current.children[char]!!
        }

        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        return searchHelper(word, 0, root)
    }

    private fun searchHelper(word: String, index: Int, node: TrieNode): Boolean {
        if (index == word.length) {
            return node.isEndOfWord
        }

        val char = word[index]

        return if (char == '.') {
            for (child in node.children.values) {
                if (searchHelper(word, index + 1, child)) {
                    return true
                }
            }
            false
        } else {
            val child = node.children[char] ?: return false
            searchHelper(word, index + 1, child)
        }
    }
}

fun main() {
    val wordDictionary = WordDictionary()

    wordDictionary.addWord("bad")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mad")

    println(wordDictionary.search("pad"))  // false
    println(wordDictionary.search("bad"))  // true
    println(wordDictionary.search(".ad"))  // true
    println(wordDictionary.search("b.."))  // true
}
