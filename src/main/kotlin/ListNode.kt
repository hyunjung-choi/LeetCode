class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        val result = mutableListOf<Int>()
        var current: ListNode? = this
        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }
        return result.toString()
    }
}
