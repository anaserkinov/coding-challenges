package leetcode.p0304_range_sum_query_2d_immutable

class NumMatrix(private val matrix: Array<IntArray>) {

    init {
        val height = matrix.size
        val width = matrix[0].size
        for (i in 0 until height){
            for (j in 1 until width)
                matrix[i][j] += matrix[i][j - 1]
        }
        for (j in 0 until width){
            for (i in 1 until height)
                matrix[i][j] += matrix[i - 1][j]
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var result = matrix[row2][col2]
        if (col1 != 0)
            result -= matrix[row2][col1 - 1]
        if (row1 != 0)
            result -= matrix[row1 - 1][col2]
        if (col1 != 0 && row1 != 0)
            result += matrix[row1 - 1][col1 - 1]
        return result
    }

}