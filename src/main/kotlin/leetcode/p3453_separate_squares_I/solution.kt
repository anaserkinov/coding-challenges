package leetcode.p3453_separate_squares_I

class Solution {
    fun separateSquares(squares: Array<IntArray>): Double {
        var min = 0.0
        var max = 2e9
        repeat(60){
            val mid = (max + min)/2.0
            var below = 0.0
            var above = 0.0
            for (sq in squares){
                val y = sq[1].toDouble()
                val l = sq[2].toDouble()
                val size = l * l
                when{
                    mid <= y -> above += size
                    mid >= y + l-> below += size
                    else -> {
                        val aboveHeight = (y + l) - mid
                        val belowHeight = mid - y
                        above += l * aboveHeight
                        below += l * belowHeight
                    }
                }
            }
            if (above - below > 0) min = mid
            else max = mid
        }
        return max
    }
}