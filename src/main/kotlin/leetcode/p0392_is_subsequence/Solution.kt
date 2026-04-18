package leetcode.p0392_is_subsequence

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) return false
        var index = 0
        t.forEach {
            if (index == s.length) return true
            if (it == s[index]) index++
        }
        return index == s.length
    }
}