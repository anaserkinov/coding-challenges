package leetcode.p0417_pacific_atlantic_water_flow

class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val height = heights.size
        val width = heights[0].size
        val result = ArrayList<List<Int>>()
        val state = IntArray(height * width)
        var flag = 0b1
        fun dfs(y: Int, x: Int, from: Int){
            if (x == -1 || x == width || y == -1 || y == height || heights[y][x] < from) return
            val index = y * width + x
            if (state[index] and flag != 0) return
            state[index] = state[index] or flag
            val height = heights[y][x]
            dfs(y, x + 1, height)
            dfs(y, x - 1, height)
            dfs(y + 1, x, height)
            dfs(y - 1, x, height)
        }
        repeat(height){
            flag = 0b1
            dfs(it, 0, 0)
            flag = 0b10
            dfs(it, width - 1, 0)
        }

        repeat(width - 1){
            flag = 0b1
            dfs(0, it + 1, 0)
            flag = 0b10
            dfs(height - 1, it, 0)
        }

        repeat(height){ y ->
            repeat(width){ x ->
                if (state[y * width + x] == 0b11)
                    result.add(listOf(y, x))
            }
        }
        return result
    }
}