package leetcode.p0097_interleaving_string

class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false
        val m = BooleanArray((s1.length + 1) * (s2.length + 1))
        fun s(index1: Int, index2: Int, index3: Int): Boolean {
            if (index3 == s3.length) return index1 == s1.length && index2 == s2.length
            m[index1 * (s1.length + 1) + index2].let { if (it) return false }
            if (index1 < s1.length && s1[index1] == s3[index3]){
                if (s(index1 + 1, index2, index3 + 1)) return true
            }
            if (index2 < s2.length && s2[index2] == s3[index3]){
                if (s(index1, index2 + 1, index3 + 1)) return true
            }
            m[index1 * (s1.length + 1) + index2] = true
            return false
        }
        return s(0, 0, 0)
    }
}