package leetcode.p0056_merge_intervals

import kotlin.math.max

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = ArrayList<IntArray>(intervals.size)
        result.add(intervals[0])

        for (i in 1 until intervals.size){
            val pre = result.last()
            val interval = intervals[i]

            if (interval[0] > pre[1])
                result.add(interval)
            else
                pre[1] = max(pre[1], interval[1])
        }

        return result.toTypedArray()
    }
}