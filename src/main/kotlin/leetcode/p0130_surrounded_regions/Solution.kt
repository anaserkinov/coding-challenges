package leetcode.p0130_surrounded_regions

class Solution {
    fun solve(board: Array<CharArray>): Unit {
        val height = board.size
        val width = board[0].size
        fun dfs(y: Int, x: Int){
            if (x == -1 || x == width || y == -1 || y == height || board[y][x].code > 86) return
            board[y][x] = 'W'
            dfs(y + 1, x)
            dfs(y - 1, x)
            dfs(y, x + 1)
            dfs(y, x - 1)
        }
        repeat(height){
            dfs(it, 0)
            dfs(it, width - 1)
        }
        repeat(width - 2){
            dfs(0, it + 1)
            dfs(height - 1 , it + 1)
        }
        repeat(height) { y ->
            repeat(width) { x ->
                if (board[y][x] == 'W')
                    board[y][x] = 'O'
                else if (board[y][x] == 'O')
                    board[y][x] = 'X'
            }
        }
    }
}