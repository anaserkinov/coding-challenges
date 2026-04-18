package leetcode.p2435_paths_in_matrix_whose_sum_is_divisible_by_k

class Solution {
    fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
        val height = grid.size
        val width = grid[0].size
        val dp = Array(height) { Array(width){ IntArray(k){ -1 } } }

        fun dfs(y: Int, x: Int, rSum: Int): Int {
            if (y == height || x == width) return 0
            if (y == height - 1 && x == width - 1)
                return if ((grid[y][x] + rSum)%k == 0) 1 else 0
            val dpV = dp[y][x][(k - rSum)%k]
            if (dpV != -1) return dpV
            val remainder = (rSum + grid[y][x]%k)%k
            var result = dfs(y + 1, x, remainder) +
                    dfs(y, x + 1, remainder)
            result %= 1_000_000_007
            dp[y][x][(k - rSum)%k] = result
            return result
        }

        return dfs(0, 0, 0)
    }
}