package leetcode.p0057_insert_interval

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = ArrayList<IntArray>(intervals.size + 1)
        var i = 0

        while (i < intervals.size && intervals[i][1] < newInterval[0]){
            result.add(intervals[i])
            i ++
        }

        var newStart = newInterval[0]
        var newEnd = newInterval[1]
        while (i < intervals.size && newEnd >= intervals[i][0]){
            newStart = min(newStart, intervals[i][0])
            newEnd = max(newEnd, intervals[i][1])
            i ++
        }
        result.add(intArrayOf(newStart, newEnd))

        while (i < intervals.size){
            result.add(intervals[i])
            i ++
        }

        return result.toTypedArray()
    }
}