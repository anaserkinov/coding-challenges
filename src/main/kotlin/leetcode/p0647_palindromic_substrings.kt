package leetcode.p0647_palindromic_substrings


class Solution {
    fun countSubstrings(s: String): Int {
        fun count(l: Int, r: Int): Int {
            var left = l
            var right = r
            var res = 0
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                res++
                left--
                right++
            }
            return res
        }
        var res = 0
        for (i in s.indices) {
            res += count(i, i)
            res += count(i, i + 1)
        }
        return res
    }
}