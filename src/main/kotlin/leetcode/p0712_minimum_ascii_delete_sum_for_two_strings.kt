package leetcode.p0712_minimum_ascii_delete_sum_for_two_strings

import kotlin.math.max

class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }
        for (i in 1..s1.length){
            for (j in 1..s2.length){
                dp[i][j] = if (s1[i - 1] == s2[j - 1])
                    dp[i - 1][j - 1] + s1[i - 1].code
                else
                    max(
                        dp[i][j - 1],
                        dp[i - 1][j]
                    )
            }
        }
        return s1.sumOf { it.code } + s2.sumOf { it.code } - 2 * dp[s1.length][s2.length]
    }
}