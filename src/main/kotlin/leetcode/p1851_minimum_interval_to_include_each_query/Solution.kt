package leetcode.p1851_minimum_interval_to_include_each_query

import java.util.*

class Solution {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        intervals.sortBy { it[0] }

        val queriesWithIndex = queries.withIndex()
            .map { it.value to it.index }
            .sortedBy { it.first }

        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        val result = IntArray(queries.size)
        var i = 0

        for ((q, originalIdx) in queriesWithIndex) {
            while (i < intervals.size && intervals[i][0] <= q) {
                val size = intervals[i][1] - intervals[i][0] + 1
                minHeap.offer(size to intervals[i][1])
                i++
            }

            while (minHeap.isNotEmpty() && minHeap.peek().second < q) {
                minHeap.poll()
            }

            result[originalIdx] = if (minHeap.isNotEmpty()) minHeap.peek().first else -1
        }

        return result
    }
}