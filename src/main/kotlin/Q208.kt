/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */

fun main() {
    val trie = Trie()
    trie.insert("apple")
    println(trie.search("apple"))   // true
    println(trie.search("app"))     // false
    println(trie.startsWith("app"))         // true
    trie.insert("app")
    println(trie.search("app"))     // true
}
