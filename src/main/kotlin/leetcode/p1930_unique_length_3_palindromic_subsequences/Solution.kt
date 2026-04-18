package leetcode.p1930_unique_length_3_palindromic_subsequences

class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val chars = IntArray(26){ -1 }
        s.forEachIndexed { index, c ->
            chars[c.code - 97] = index
        }

        fun count(start: Int, end: Int): Int {
            var count = 0
            var mask = 0
            for (i in start..end){
                val code = s[i].code - 97
                if ((mask shr code) and 0b1 == 0){
                    count ++
                    mask = mask or (0b1 shl code)
                }
            }
            return count
        }

        var result = 0
        s.forEachIndexed { index, c ->
            val lastIndex = chars[c.code - 97]
            if (index == lastIndex || lastIndex == -1) return@forEachIndexed
            result += count(index + 1, lastIndex - 1)
            chars[c.code - 97] = -1
        }
        return result
    }
}