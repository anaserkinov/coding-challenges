package leetcode.p1351_count_negative_numbers_in_a_sorted_matrix

class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        val width = grid[0].size
        var x = 0
        var result = 0
        for (y in grid.size - 1 downTo 0){
            val row = grid[y]
            while (x < width && row[x] >= 0) x ++
            result += width - x
        }
        return result
    }
}