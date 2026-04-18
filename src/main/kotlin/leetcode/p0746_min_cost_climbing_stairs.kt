package leetcode.p0746_min_cost_climbing_stairs

import kotlin.math.min

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size + 2)
        dp[cost.size] = 0
        for (i in cost.size - 1 downTo 0){
            dp[i] = cost[i] + min(dp[i + 1], dp[i + 2])
        }
        return min(dp[0], dp[1])
    }
}