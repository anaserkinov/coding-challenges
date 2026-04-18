package leetcode.p0036_valid_sudoku

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val hCheck = BooleanArray(9)
        val vCheck = BooleanArray(9)
        val bCheck = BooleanArray(9)
        repeat(9){ j ->
            val rowStart: Int = (j / 3) * 3
            val columnStart: Int = (j % 3) * 3

            repeat(9){ k ->

                // horizontal
                var code = board[j][k].code - 49
                if (code >= 0){
                    if (hCheck[code])
                        return false
                    hCheck[code] = true
                }

                // vertical
                code = board[k][j].code - 49
                if (code >= 0){
                    if (vCheck[code])
                        return false
                    vCheck[code] = true
                }

                // box
                code = board[rowStart + k/3][columnStart + k%3].code - 49
                if (code >= 0){
                    if (bCheck[code])
                        return false
                    bCheck[code] = true
                }
            }

            repeat(9){
                hCheck[it] = false
                vCheck[it] = false
                bCheck[it] = false
            }
        }

        return true
    }
}