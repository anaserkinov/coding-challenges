package leetcode.p3531_count_covered_buildings

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
        if(buildings.size <= 4) return 0
        val x = Array<IntArray?>(n + 1){ null }
        val y = Array<IntArray?>(n + 1){ null }
        for (b in buildings){
            val xm = x[b[0]] ?: intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE).also { x[b[0]] = it }
            xm[0] = min(xm[0], b[1])
            xm[1] = max(xm[1], b[1])
            val ym = y[b[1]] ?: intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE).also { y[b[1]] = it }
            ym[0] = min(ym[0], b[0])
            ym[1] = max(ym[1], b[0])
        }
        var count = 0
        for (b in buildings){
            if (
                x[b[0]]!![0] < b[1] && b[1] < x[b[0]]!![1] &&
                y[b[1]]!![0] < b[0] && b[0] < y[b[1]]!![1]
                ) count ++
        }
        return count
    }
}