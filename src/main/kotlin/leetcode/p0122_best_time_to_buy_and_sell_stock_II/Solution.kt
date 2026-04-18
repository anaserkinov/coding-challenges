package leetcode.p0122_best_time_to_buy_and_sell_stock_II

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 0 until prices.size - 1){
            if (prices[i + 1] > prices[i])
                result += prices[i + 1] - prices[i]
        }
        return result
    }
}