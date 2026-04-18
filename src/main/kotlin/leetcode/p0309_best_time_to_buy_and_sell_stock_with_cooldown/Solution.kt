package leetcode.p0309_best_time_to_buy_and_sell_stock_with_cooldown

import kotlin.math.max

class Solution {
    fun maxProfit(prices: IntArray): Int {
        val dp = IntArray(prices.size * 2) { -1 }
        fun nextDay(i: Int, buy: Boolean): Int{
            if (i >= prices.size) return 0
            dp[i * 2 + if (buy) 0  else 1].let { if (it != -1) return it }

            val skip = nextDay(i + 1, buy)
            val max = max(
                skip,
                if (buy)
                    nextDay(i + 1, false) - prices[i]
                else
                    nextDay(i + 2, true) + prices[i]
            )
            dp[i * 2 + if (buy) 0  else 1] = max
            return max
        }
        return nextDay(0, true)
    }
}