/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists
 */

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var current = dummy

    var p1 = list1
    var p2 = list2

    while (p1 != null && p2 != null) {
        if (p1.`val` >= p2.`val`) {
            current.next = p2
            p2 = p2.next
        } else {
            current.next = p1
            p1 = p1.next
        }

        current = current.next!!
    }

    current.next = p1 ?: p2

    return dummy.next
}

private fun createListNode(values: IntArray): ListNode? {
    if (values.isEmpty()) return null

    val head = ListNode(values[0])
    var current = head

    for (i in 1 until values.size) {
        current.next = ListNode(values[i])
        current = current.next!!
    }

    return head
}

fun main() {
    val testCases = arrayOf(
        intArrayOf(1, 2, 4) to intArrayOf(1, 3, 4), // [1, 1, 2, 3, 4, 4]
        intArrayOf() to intArrayOf(),               // []
        intArrayOf() to intArrayOf(0)               // [0]
    )

    testCases.forEach { (arr1, arr2) ->
        val list1 = createListNode(arr1)
        val list2 = createListNode(arr2)

        println("Input: list1 = ${arr1.contentToString()}, list2 = ${arr2.contentToString()}")
        println("Output: ${mergeTwoLists(list1, list2)}")
        println()
    }
}
