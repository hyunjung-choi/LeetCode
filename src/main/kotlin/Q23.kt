import java.util.*

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists
 */

private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val minHeap = PriorityQueue<ListNode> { a, b ->
        a.`val` - b.`val`
    }

    for (list in lists) {
        list?.let { minHeap.add(it) }
    }

    val dummy = ListNode(0)
    var current = dummy

    while (minHeap.isNotEmpty()) {
        val node = minHeap.poll()

        current.next = node
        current = node

        node.next?.let { minHeap.add(it) }
    }

    return dummy.next
}


fun main() {
    // 예제 1: [[1,4,5],[1,3,4],[2,6]]

    // 첫 번째 리스트: 1->4->5
    val list1 = ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(5)
        }
    }

    // 두 번째 리스트: 1->3->4
    val list2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4)
        }
    }

    // 세 번째 리스트: 2->6
    val list3 = ListNode(2).apply {
        next = ListNode(6)
    }

    val lists = arrayOf<ListNode?>(list1, list2, list3)

    // 병합된 리스트 출력
    var result = mergeKLists(lists)
    val resultValues = mutableListOf<Int>()

    while (result != null) {
        resultValues.add(result.`val`)
        result = result.next
    }

    println(resultValues) // [1, 1, 2, 3, 4, 4, 5, 6]
}
