package leetcode.p0051_n_queens


class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val board = Array(n) { CharArray(n) { '.' } }
        val result = mutableListOf<List<String>>()

        val cols = IntArray(n)
        val diag1 = IntArray(2 * (n - 1) + 1)
        val diag2 = IntArray(2 * (n - 1) + 1)

        fun backtrack(row: Int) {
            if (row == n) {
                result.add(board.map { String(it) })
                return
            }

            for (col in 0 until n) {
                if (cols[col] != 0 || diag1[row - col + n -1] != 0 || diag2[row + col] != 0) continue


                board[row][col] = 'Q'
                cols[col] = 1
                diag1[row - col + n -1] = 1
                diag2[row + col] = 1

                backtrack(row + 1)

                board[row][col] = '.'
                cols[col] = 0
                diag1[row - col + n -1] = 0
                diag2[row + col] = 0
            }
        }

        backtrack(0)
        return result
    }
}