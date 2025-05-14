/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list
 */

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head

        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        return prev
    }
}
