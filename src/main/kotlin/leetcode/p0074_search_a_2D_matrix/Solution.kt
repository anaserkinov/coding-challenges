package leetcode.p0074_search_a_2D_matrix

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val cols = matrix[0].size
        var l = 0
        var r = matrix.size * cols - 1

        while (l <= r) {
            val m = (l + r) shr 1
            val row = m / cols
            val col = m % cols
            when {
                matrix[row][col] == target -> return true
                matrix[row][col] < target -> l = m + 1
                else -> r = m - 1
            }
        }
        return false
    }
}