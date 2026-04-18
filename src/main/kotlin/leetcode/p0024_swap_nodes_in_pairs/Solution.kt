package leetcode.p0024_swap_nodes_in_pairs

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val result = head.next
        var left = head
        var right = head.next
        var pre: ListNode? = null
        while (left != null && right != null){
            left.next = right.next
            right.next = left
            pre?.next = right
            pre = left
            left = left.next
            right = left?.next
        }
        return result
    }
}

fun main() {
    Solution()
        .swapPairs(
            ListNode(1).also {
                it.next = ListNode(2).also {
                    it.next =ListNode(3).also {
                        it.next =ListNode(4)
                    }
                }
            }
        )
}