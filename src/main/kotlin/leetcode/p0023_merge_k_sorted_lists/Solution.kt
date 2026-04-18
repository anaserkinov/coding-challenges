package leetcode.p0023_merge_k_sorted_lists

import leetcode.p0025_reverse_nodes_in_k_group.ListNode


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class Solution {
    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            return l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            return l2
        }
    }
    private fun merge(lists: Array<ListNode?>, from: Int, to: Int): ListNode?{
        if (from == to) return lists[from]
        val mid = from + (to - from)/2
        return mergeTwoLists(
            merge(lists, from, mid),
            merge(lists, mid + 1, to)
        )
    }
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.size <= 1) return lists.firstOrNull()
        return merge(lists, 0, lists.size - 1)
    }
}