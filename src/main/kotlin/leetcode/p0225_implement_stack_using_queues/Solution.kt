package leetcode.p0225_implement_stack_using_queues

import java.util.LinkedList

class MyStack() {

    private val q = LinkedList<Int>()

    fun push(x: Int) {
        q.add(x)
        repeat(q.size-1){
            q.add(q.poll())
        }
    }

    fun pop(): Int {
        return q.poll()
    }

    fun top(): Int {
        return q.peek()
    }

    fun empty(): Boolean {
        return q.isEmpty()
    }
}