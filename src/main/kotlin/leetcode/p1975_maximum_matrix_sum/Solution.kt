package leetcode.p1975_maximum_matrix_sum

import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var minAbs = Int.MAX_VALUE
        var countNegative = 0
        var absSum = 0L
        for (row in matrix){
            for (cell in row){
                val absValue = abs(cell)
                absSum += absValue
                minAbs = min(minAbs, absValue)
                if (cell < 0) countNegative ++
            }
        }
        return if (countNegative % 2 == 0) absSum
        else absSum - 2L * minAbs
    }
}