package leetcode.p3652_best_time_to_buy_and_sell_stock_using_strategy

import kotlin.math.max

class Solution {
    fun maxProfit(prices: IntArray, strategy: IntArray, k: Int): Long {
        val pricePrefix = LongArray(prices.size + 1)
        val profitPrefix = LongArray(prices.size + 1)
        for (i in prices.indices) {
            pricePrefix[i + 1] = pricePrefix[i] + prices[i]
            profitPrefix[i + 1] = profitPrefix[i] + (prices[i] * strategy[i].toLong())
        }
        var result = profitPrefix[prices.size]
        for (i in 0 .. prices.size - k){
            val profit = profitPrefix[i] +
                    pricePrefix[i + k] - pricePrefix[i + k/2] +
                    profitPrefix[prices.size] - profitPrefix[i + k]
            result = max(result, profit)
        }
        return result
    }
}