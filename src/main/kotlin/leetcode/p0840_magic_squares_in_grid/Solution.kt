package leetcode.p0840_magic_squares_in_grid


class Solution {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        var count = 0
        fun checkH(y: Int, x: Int): Boolean{
            for (i in 0 until 3)
                if (grid[y + i][x] + grid[y + i][x + 1] + grid[y + i][x + 2] != 15 ) return false
            return true
        }
        fun checkV(y: Int, x: Int): Boolean{
            for (i in 0 until 3)
                if (grid[y][x + i] + grid[y + 1][x + i] + grid[y + 2][x + i] != 15 ) return false
            return true
        }
        fun checkD(y: Int, x: Int, offset: Int): Boolean {
            return grid[y][x] + grid[y + offset][x + 1] + grid[y + 2 * offset][x + 2] == 15
        }
        for(y in 0 until grid.size - 2){
            for (x in 0 until grid[0].size - 2){
                if (
                    grid[y][x]%2 != 0 ||
                    grid[y + 2][x]%2 != 0 ||
                    grid[y][x + 2]%2 != 0 ||
                    grid[y + 2][x + 2]%2 != 0
                ) continue
                if (!checkH(y, x)) continue
                if (!checkV(y, x)) continue
                if (!checkD(y, x, 1)) continue
                if (!checkD(y + 2, x, -1)) continue
                var total = 1
                for (i in 0 until 3){
                    total *= grid[y + i][x] * grid[y + i][x + 1] * grid[y + i][x + 2]
                }
                if (total == 362880) count ++
            }
        }
        return count
    }
}

fun main() {
    Solution()
        .numMagicSquaresInside(
            arrayOf(
                intArrayOf(4,3,8,4),
                intArrayOf(9,5,1,9),
                intArrayOf(2,7,6,2)
            )
        )
}