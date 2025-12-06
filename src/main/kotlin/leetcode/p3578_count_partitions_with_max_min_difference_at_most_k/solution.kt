package leetcode.p3578_count_partitions_with_max_min_difference_at_most_k

class Solution {
    fun countPartitions(nums: IntArray, k: Int): Int {
        val MOD = 1_000_000_007
        val dp = LongArray(nums.size + 1)
        dp[0] = 1

        val mx = IntArray(nums.size)
        val mn = IntArray(nums.size)
        var mxl = 0
        var mxr = 0
        var mnl = 0
        var mnr = 0

        var l = 0
        var sum = 0L

        for (r in 0 until nums.size) {
            while (mxl < mxr && nums[mx[mxr - 1]] <= nums[r]) mxr--
            while (mnl < mnr && nums[mn[mnr - 1]] >= nums[r]) mnr--
            mx[mxr++] = r
            mn[mnr++] = r

            while (nums[mx[mxl]] - nums[mn[mnl]] > k) {
                if (mx[mxl] == l) mxl++
                if (mn[mnl] == l) mnl++
                sum = (sum - dp[l] + MOD) % MOD
                l++
            }

            sum = (sum + dp[r]) % MOD
            dp[r + 1] = sum
        }

        return dp[nums.size].toInt()
    }
}