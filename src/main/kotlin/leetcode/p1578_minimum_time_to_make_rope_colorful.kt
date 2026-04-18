package leetcode.p1578_minimum_time_to_make_rope_colorful

import kotlin.math.max

class Solution {
    fun minCost(colors: String, neededTime: IntArray): Int {
        var result = 0
        var maxTime = 0
        var preItem: Char? = null
        colors.forEachIndexed { index, c ->
            if (preItem == c) {
                result += neededTime[index]
                maxTime = max(maxTime, neededTime[index])
            } else {
                result -= maxTime
                preItem = c
                maxTime = neededTime[index]
                result += maxTime
            }
        }
        result -= maxTime

        return result
    }
}