package leetcode.p0300_longest_increasing_subsequence

import kotlin.math.max

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val memo = IntArray(n) { -1 }

        fun dfs(i: Int): Int {
            if (memo[i] != -1) return memo[i]

            var LIS = 1
            for (j in i + 1 until nums.size) {
                if (nums[i] < nums[j])
                    LIS = max(LIS, 1 + dfs(j))
            }

            memo[i] = LIS
            return LIS
        }

        var maxLIS = 1
        for (i in nums.indices) {
            maxLIS = max(maxLIS, dfs(i))
        }
        return maxLIS
    }

}