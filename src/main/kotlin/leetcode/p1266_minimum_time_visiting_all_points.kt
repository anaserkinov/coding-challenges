package leetcode.p1266_minimum_time_visiting_all_points

import kotlin.math.abs

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var result = 0
        for (i in 1 until points.size) {
            val from = points[i - 1]
            val to = points[i]
            val xOffset = abs(to[0] - from[0])
            val yOffset = abs(to[1] - from[1])
            result += if (xOffset > yOffset)
                xOffset
            else
                yOffset
        }
        return result
    }
}