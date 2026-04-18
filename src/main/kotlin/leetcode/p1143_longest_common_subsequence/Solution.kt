package leetcode.p1143_longest_common_subsequence

import kotlin.math.max

class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = IntArray((text1.length + 1) * (text2.length + 1))

        for (i in 1..text1.length) {
            for (j in 1..text2.length) {
                m[j * text1.length + i] = if(text1[i - 1] == text2[j - 1])
                    1 + m[(j - 1) * text1.length + i - 1]
                else
                    max(
                        m[j * text1.length + i - 1],
                        m[(j - 1) * text1.length + i]
                    )
            }
        }
        return m[text2.length * text1.length + text1.length]
    }
}