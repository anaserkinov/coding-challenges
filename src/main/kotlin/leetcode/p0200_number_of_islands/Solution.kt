package leetcode.p0200_number_of_islands

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val height = grid.size
        val width = grid[0].size
        fun dfs(x: Int, y: Int){
            if (x == -1 || x == width || y == -1 || y == height) return
            if (grid[y][x] == '1'){
                grid[y][x] = '0'
                dfs(x + 1, y)
                dfs(x - 1, y)
                dfs(x, y + 1)
                dfs(x, y - 1)
            }
        }
        var count = 0
        repeat(height) { y ->
            repeat(width) { x ->
                if (grid[y][x] == '1') {
                    count++
                    dfs(x, y)
                }
            }
        }
        return count
    }
}