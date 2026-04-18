package leetcode.p0143_reorder_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return
        var secondHead: ListNode?
        // split
        run {
            var slow = head
            var fast = head
            while (slow != null && fast?.next != null){
                slow = slow.next
                fast = fast.next!!.next
            }
            secondHead = slow?.next
            slow?.next = null
        }
        // reverse
        run {
            if(secondHead == null) return
            var current = secondHead
            var result: ListNode? = null
            while (current != null){
                result = ListNode(current.`val`).also {
                    it.next = result
                }
                current = current.next
            }
            secondHead = result
        }
        // merge
        var firstHead: ListNode? = head
        while (firstHead != null && secondHead != null){
            val firstNext = firstHead.next
            val secondNext = secondHead!!.next
            firstHead.next = secondHead
            secondHead!!.next = firstNext
            firstHead = firstNext
            secondHead = secondNext
        }
    }
}

fun main() {
    var result: ListNode? = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    Solution().reorderList(result)
    while (result != null){
        println(result.`val`)
        result = result.next
    }
}