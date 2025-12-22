package leetcode.p0019_remove_nth_node_from_end_of_ist

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) return null
        var first = head
        var second = head
        repeat(n - 1){
            second = second?.next
        }
        if (second?.next == null) return first.next
        while (true){
            second = second?.next
            if (second?.next == null){
                first?.next = first?.next?.next
                return head
            }
            first = first?.next
        }
    }
}