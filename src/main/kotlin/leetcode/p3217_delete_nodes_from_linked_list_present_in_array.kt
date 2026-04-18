package leetcode.p3217_delete_nodes_from_linked_list_present_in_array

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val array = BooleanArray(nums.max() + 1)
        nums.forEach { array[it] = true }
        var head = head
        var pre: ListNode? = null
        var current = head
        while (current != null){
            if (current.`val` < array.size && array[current.`val`]){
                current = current.next
                if (pre == null)
                    head = current
                else
                    pre.next = current
            } else {
                pre = current
                current = current.next
            }
        }
        return head
    }
}