package leetcode.p0960_delete_columns_to_make_sorted_III

import kotlin.math.max

class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        val length = strs[0].length
        val dp = IntArray(length) { 1 }
        var max = 0
        fun check(j: Int, i: Int): Boolean {
            for (s in strs)
                if (s[j] > s[i]) return false
            return true
        }
        for (i in 0 until length) {
            for (j in 0 until i) {
                if (check(j, i)) {
                    dp[i] = max(dp[i], dp[j] + 1)
                }
            }
            max = max(max, dp[i])
        }
        return length - max
    }

}
