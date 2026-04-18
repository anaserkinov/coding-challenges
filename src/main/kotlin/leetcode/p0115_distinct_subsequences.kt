package leetcode.p0115_distinct_subsequences

class Solution {
    fun numDistinct(s: String, t: String): Int {
        if (t.length > s.length) return 0
        val m = Array(s.length){ IntArray(t.length){ -1 } }
        fun search(sIndex: Int, tIndex: Int): Int{
            if (tIndex == t.length) return 1
            if (sIndex == s.length) return 0
            m[sIndex][tIndex].let { if (it != -1) return it }
            var result = 0
            if (s[sIndex] == t[tIndex])
                result += search(sIndex + 1, tIndex + 1)
            result += search(sIndex + 1, tIndex)
            m[sIndex][tIndex] = result
            return result
        }
        return search(0, 0)
    }
}