package leetcode.p0073_set_matrix_zeroes

class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val height = matrix.size
        val width = matrix[0].size
        var firstCell = 0
        for (y in 0 until height)
            for (x in 0 until width)
                if (matrix[y][x] == 0){
                    if (y == 0) firstCell = firstCell or 0b1
                    else matrix[y][0] = 0

                    if (x == 0) firstCell = firstCell or 0b10
                    else matrix[0][x] = 0
                }
        for (y in 1 until height)
            for (x in 1 until width)
                if (matrix[y][0] == 0 || matrix[0][x] == 0)
                    matrix[y][x] = 0
        if (firstCell and 0b1 != 0)
            for (i in 0 until width)
                matrix[0][i] = 0
        if (firstCell and 0b10 != 0)
            for (i in 0 until height)
                matrix[i][0] = 0
    }
}