package leetcode.p0048_rotate_image

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val clone = Array(matrix.size){ matrix[it].copyOf() }
        repeat((matrix.size + 1)/2){ start ->
            val end = matrix.size - 1 - start
            for (i in 0 until (end - start)){
                val temp = matrix[end - i][start]
                matrix[end - i][start] = matrix[end][end - i]
                matrix[end][end - i] = matrix[start + i][end]
                matrix[start + i][end] = matrix[start][start + i]
                matrix[start][start + i] = temp
            }
        }
    }
}