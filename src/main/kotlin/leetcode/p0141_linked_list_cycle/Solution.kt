package leetcode.p0141_linked_list_cycle

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var fast = head
        var slow = head
        while (fast != null && slow != null){
            fast = fast.next?.next
            slow = slow.next
            if (fast === slow && fast != null) return true
        }
        return false
    }
}