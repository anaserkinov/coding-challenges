package leetcode.p0474_ones_and_zeroes

import kotlin.math.max


class Solution {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (str in strs) {
            val zeros = str.count { it == '0' }
            val ones = str.length - zeros

            for (i in m downTo zeros) {
                for (j in n downTo ones) {
                    dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1)
                }
            }
        }

        return dp[m][n]
    }
}