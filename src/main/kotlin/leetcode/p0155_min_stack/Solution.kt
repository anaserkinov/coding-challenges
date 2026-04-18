package leetcode.p0155_min_stack

data class Node(
    val value: Int,
    val min: Int,
    var next: Node? = null,
    var prev: Node? = null
)


class MinStack() {

    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)
    private var curr = head

    init {
        head.next = tail
        tail.prev = head
    }

    fun push(`val`: Int) {
        val node = Node(
            `val`,
            if (curr == head || curr.min > `val`) `val` else curr.min,
            tail,
            curr
        )
        curr.next = node
        curr = node
        tail.prev = curr
        if (head.next == tail) head.next = curr
    }

    fun pop() {
        curr = curr.prev!!
        tail.prev = curr
        curr.next = tail
    }

    fun top() = curr.value

    fun getMin() = curr.min

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */