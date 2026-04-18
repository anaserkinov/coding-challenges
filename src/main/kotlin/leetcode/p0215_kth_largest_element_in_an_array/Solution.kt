package leetcode.p0215_kth_largest_element_in_an_array

import java.util.*

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>()
        nums.forEach {
            heap.add(it)
            if (heap.size > k) heap.poll()
        }
        return heap.peek()
    }
}