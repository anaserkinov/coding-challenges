package leetcode.p0025_reverse_nodes_in_k_group

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    private fun reverseList(head: ListNode): ListNode {
        var current: ListNode? = head
        var result: ListNode? = null
        while (current != null){
            val next = current.next
            result = current.also {
                it.next = result
            }
            current = next
        }
        return result!!
    }
    fun reverseKGroup(head: ListNode, k: Int): ListNode {
        if (head.next == null || k == 1) return head
        val dummy = ListNode(0)
        var groupCurrent: ListNode? = dummy

        var groupHead: ListNode? = head
        var current: ListNode? = head
        var count = 1
        while (current != null){
            current = if (count == k){
                val next = current.next
                current.next = null
                groupCurrent!!.next = reverseList(groupHead!!)
                groupCurrent = groupHead
                groupHead = next
                count = 0
                next
            } else
                current.next
            count ++
        }
        groupCurrent!!.next = groupHead

        return dummy.next!!
    }
}