package leetcode.p0329_longest_increasing_path_in_a_matrix

import kotlin.math.max

class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val height = matrix.size
        val width = matrix[0].size
        val m = Array(height){ IntArray(width){ -1 } }
        fun s(x: Int, y: Int, pre: Int): Int{
            if (x < 0 || x >= width || y < 0 || y >= height) return 0
            val value = matrix[y][x]
            if (value <= pre) return 0
            m[y][x].let { if (it != -1) return it + 1 }
            val result =max(
                max(s(x + 1, y, value), s(x - 1, y, value)),
                max(s(x, y + 1, value), s(x, y - 1, value))
            )
            m[y][x] = result
            return 1 + result
        }
        var result = 0
        repeat(height){ y ->
            repeat(width){ x ->
                result = max(result, s(x, y, -1))
            }
        }
        return result
    }
}