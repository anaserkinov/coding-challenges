package leetcode.p0083_remove_duplicates_from_sorted_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var pre = head
        var current = head?.next
        while (current != null){
            if (current.`val` == pre!!.`val`)
                pre.next = current.next
            else
                pre = current
            current = current.next
        }
        return head
    }
}