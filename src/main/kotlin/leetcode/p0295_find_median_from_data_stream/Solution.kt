package leetcode.p0295_find_median_from_data_stream

import java.util.*

class MedianFinder() {

    private val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num)
        else
            minHeap.offer(num)
        if (maxHeap.size - minHeap.size == 2)
            minHeap.offer(maxHeap.poll())
        else if (minHeap.size - maxHeap.size == 2)
            maxHeap.offer(minHeap.poll())
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size)
            (maxHeap.peek() + minHeap.peek())/2.0
        else if (maxHeap.size > minHeap.size)
            maxHeap.peek().toDouble()
        else
            minHeap.peek().toDouble()
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */