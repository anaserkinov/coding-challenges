package leetcode.p3573_best_time_to_buy_and_sell_stock_v


class Solution {
    fun maximumProfit(prices: IntArray, k: Int): Long {
        val min = -1_000_000_000_000L
        val dp = Array(prices.size){ Array(k){ LongArray(3) { min } } }
        fun f(day: Int, state: Int, transactionCount: Int): Long {
            if (day == prices.size || transactionCount == k) {
                return if (state == 0) 0 else -1_000_000_000_000L
            }
            dp[day][transactionCount][state].let { if (it != min) return it }

            var maxProfit = f(day + 1, state, transactionCount)
            if (state == 0) {
                maxProfit = maxOf(
                    maxProfit,
                    f(day + 1, 1, transactionCount) - prices[day],
                    f(day + 1, 2, transactionCount) + prices[day]
                )
            } else {
                val profit = if (state == 1) prices[day]
                else -prices[day]
                maxProfit = maxOf(maxProfit, profit + f(day + 1, 0, transactionCount + 1))
            }
            dp[day][transactionCount][state] = maxProfit
            return maxProfit
        }

        return f(0, 0, 0)
    }
}