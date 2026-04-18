package leetcode.p0002_add_two_numbers

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var current1 = l1
        var current2 = l2
        var carry = 0
        val head = ListNode(0)
        var current = head
        while (current1 != null || current2 != null){
            val value1 = current1?.`val` ?: 0
            val value2 = current2?.`val` ?: 0
            val sum = value1 + value2 + carry
            carry = 0
            current.next = ListNode(
                if (sum >= 10){
                    carry = 1
                    sum - 10
                } else
                    sum
            )
            current = current.next!!

            current1 = current1?.next
            current2 = current2?.next
        }
        if (carry != 0) current.next = ListNode(carry)
        return head.next
    }
}