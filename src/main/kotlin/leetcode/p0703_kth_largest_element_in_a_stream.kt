package leetcode.p0703_kth_largest_element_in_a_stream

import java.util.*

class KthLargest(private val k: Int, nums: IntArray) {
    private val heap = PriorityQueue<Int>(k)

    init {
        for (num in nums) heap.offer(num)
        while (heap.size > k) {
            heap.poll()
        }
    }

    fun add(`val`: Int): Int {
        heap.offer(`val`)
        if (heap.size > k) {
            heap.poll()
        }
        return heap.peek()
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */