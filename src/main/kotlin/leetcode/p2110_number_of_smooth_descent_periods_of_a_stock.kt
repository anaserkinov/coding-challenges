package leetcode.p2110_number_of_smooth_descent_periods_of_a_stock

class Solution {
    fun getDescentPeriods(prices: IntArray): Long {
        var result = prices.size.toLong()
        var pLength = 0
        for (i in 1 until prices.size){
            if (prices[i - 1] - prices[i] == 1)
                result += ++pLength
            else
                pLength = 0
        }
        return result
    }
}