package leetcode.p0435_non_overlapping_intervals

import kotlin.math.min

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }

        var result = 0
        var prevEnd = intervals[0][1]

        for (i in 1 until intervals.size) {
            val (start, end) = intervals[i]
            if (start >= prevEnd) {
                prevEnd = end
            } else {
                result++
                prevEnd = min(end, prevEnd)
            }
        }
        return result
    }
}