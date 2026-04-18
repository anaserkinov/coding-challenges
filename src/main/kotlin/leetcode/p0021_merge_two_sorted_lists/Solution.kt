package leetcode.p0021_merge_two_sorted_lists

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val result = ListNode(0)
        var current: ListNode? = result
        var current1 = list1
        var current2 = list2
        while (current1 != null && current2 != null){
            if (current1.`val` <= current2.`val`){
                current!!.next = ListNode(current1.`val`)
                current1 = current1.next
            } else {
                current!!.next = ListNode(current2.`val`)
                current2 = current2.next
            }
            current = current.next
        }
        current?.next = current1 ?: current2

        return result.next
    }
}