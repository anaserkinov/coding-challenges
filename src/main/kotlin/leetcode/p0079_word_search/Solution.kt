package leetcode.p0079_word_search

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val height = board.size
        val width = board.first().size
        fun backtrack(x: Int, y: Int, searchingFor: Int): Boolean{
            if (searchingFor == word.length) return true
            if (x == -1 || x == width || y == -1 || y == height) return false
            val char = board[y][x]
            if (char == ' ' || char != word[searchingFor]) return false
            board[y][x] = ' '
            if (
                backtrack(x, y - 1, searchingFor + 1) ||
                backtrack(x + 1, y, searchingFor + 1) ||
                backtrack(x, y + 1, searchingFor + 1) ||
                backtrack(x - 1, y, searchingFor + 1)
            )
                return true
            board[y][x] = char
            return false
        }

        repeat(height) { y ->
            repeat(width) { x ->
                if (backtrack(x, y, 0)) return true
            }
        }
        return false
    }
}