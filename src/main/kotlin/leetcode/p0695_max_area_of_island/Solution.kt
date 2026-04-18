package leetcode.p0695_max_area_of_island

import kotlin.math.max

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val height = grid.size
        val width = grid[0].size
        fun dfs(x: Int, y: Int): Int{
            if (x == -1 || x == width || y == -1 || y == height) return 0
            if (grid[y][x] == 1){
                grid[y][x] = 0
                return 1 + dfs(x + 1, y) +
                        dfs(x - 1, y) +
                        dfs(x, y + 1) +
                        dfs(x, y - 1)
            }
            return 0
        }
        var result = 0
        repeat(height) { y ->
            repeat(width) { x ->
                if (grid[y][x] == 1)
                    result = max(result, dfs(x, y))
            }
        }
        return result
    }
}