fun firstUniqChar(s: String): Int {
    for (ch in s) {
        val index = s.indexOf(ch)
        if (index != -1 && index == s.lastIndexOf(ch)) return index
    }
    return -1
}