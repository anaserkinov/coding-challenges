package leetcode.p0138_copy_list_with_random_pointer

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null
        var current = node
        while (current != null){
            current.next = Node(current.`val`).also {
                it.next = current!!.next
            }
            current = current.next!!.next
        }
        current = node
        while (current != null){
            current.next!!.random = current.random?.next
            current = current.next!!.next
        }

        current = node
        val copyHead = Node(0)
        var copyCurrent = copyHead

        while (current != null){
            copyCurrent.next = current.next!!.also {
                current!!.next = it.next
                current = current!!.next
            }
            copyCurrent = copyCurrent.next!!
        }

        return copyHead.next
    }
}

fun main() {
    Solution()
        .copyRandomList(
            Node(7).also {
                it.next = Node(8).also {
                    it.next = Node(9).also {
                        it.next = Node(10)
                    }
                }
            }
        )
}