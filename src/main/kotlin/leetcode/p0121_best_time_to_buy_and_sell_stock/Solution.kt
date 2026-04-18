package leetcode.p0121_best_time_to_buy_and_sell_stock

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 1) return 0

        var bought = 0
        var sold = 1
        var result = 0
        while (sold < prices.size){
            val p = prices[sold] - prices[bought]
            if (p > result)
                result = p
            else if (p < 0)
                bought = sold
            sold ++
        }
        return result
    }
}