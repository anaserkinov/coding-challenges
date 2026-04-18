package leetcode.p0312_burst_balloons

class Solution {
    fun maxCoins(nums: IntArray): Int {
        val size = nums.size
        val m = Array(size) { IntArray(size) }

        fun dfs(l: Int, r: Int): Int {
            if (l > r) return 0
            if (m[l][r] > 0) return m[l][r]

            m[l][r] = 0
            for (i in l..r) {
                val coins = (if(l == 0) 1 else nums[l - 1]) * nums[i] * (if(r == size - 1) 1 else nums[r + 1])
                val totalCoins = coins + dfs(l, i - 1) + dfs(i + 1, r)
                m[l][r] = maxOf(m[l][r], totalCoins)
            }
            return m[l][r]
        }

        return dfs(0, size - 1)
    }
}