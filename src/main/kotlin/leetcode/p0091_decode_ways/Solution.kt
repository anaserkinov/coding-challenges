package leetcode.p0091_decode_ways


class Solution {
    fun numDecodings(s: String): Int {
        val dp = IntArray(s.length  + 1) { -1 }
        dp[s.length] = 1
        fun dfs(index: Int): Int {
            dp[index].let { if (it != -1) return it }
            if (index == s.length) return 1
            if (s[index] == '0') return 0

            var res = dfs(index + 1)
            if (index + 1 < s.length && (s[index] == '1' ||
                        (s[index] == '2' && s[index + 1] <= '6'))) {
                res += dfs(index + 2)
            }
            dp[index] = res
            return res
        }
        return dfs(0)
    }
}