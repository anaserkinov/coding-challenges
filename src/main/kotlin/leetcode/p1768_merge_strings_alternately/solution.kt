package leetcode.p1768_merge_strings_alternately

import kotlin.math.max

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val result = StringBuilder(word1.length + word2.length)
        for (i in 0 until max(word1.length, word2.length)){
            if (i < word1.length) result.append(word1[i])
            if (i < word2.length) result.append(word2[i])
        }
        return result.toString()
    }
}