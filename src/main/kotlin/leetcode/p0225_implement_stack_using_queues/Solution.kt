package leetcode.p0225_implement_stack_using_queues

class MyStack() {

    private val array = IntArray(100)
    private var size = 0

    fun push(x: Int) {
        array[size++] = x
    }

    fun pop(): Int {
        return array[--size]
    }

    fun top(): Int {
        return array[size - 1]
    }

    fun empty(): Boolean {
        return size == 0
    }

}