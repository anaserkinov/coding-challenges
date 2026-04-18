package leetcode.p0416_partition_equal_subset_sum

class Solution {
    fun canPartition(nums: IntArray): Boolean {
        var sum = nums.sum()
        if (sum%2 != 0) return false
        sum /= 2

        val n = nums.size
        val memo = Array(n + 1) { BooleanArray(sum + 1) }

        fun dfs(i: Int, target: Int): Boolean {
            if (target == 0) return true
            if (i >= n || target < 0 || memo[i][target]) return false

            val found = dfs(i + 1, target) || dfs(i + 1, target - nums[i])
            if (!found) memo[i][target] = true
            return found
        }

        return dfs(0, sum)
    }
}