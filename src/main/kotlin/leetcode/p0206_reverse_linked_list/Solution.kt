package leetcode.p0206_reverse_linked_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if(head == null) return null
        var current = head
        var result: ListNode? = null
        while (current != null){
            result = ListNode(current.`val`).also {
                it.next = result
            }
            current = current.next
        }
        return result
    }
}

fun main() {
    var result = Solution()
        .reverseList(
            ListNode(1).also {
                it.next = ListNode(2).also {
                    it.next = ListNode(3).also {
                        it.next = ListNode(4).also {
                            it.next = ListNode(5)
                        }
                    }
                }
            }
        )
    while (result != null){
        println(result.`val`)
        result = result.next
    }
}