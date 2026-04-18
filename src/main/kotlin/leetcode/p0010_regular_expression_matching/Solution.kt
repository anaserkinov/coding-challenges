package leetcode.p0010_regular_expression_matching

class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val m = Array(s.length + 1) { BooleanArray(p.length + 1) }
        fun match(indexS: Int, indexP: Int): Boolean{
            if (indexP == p.length) return indexS == s.length
            m[indexS][indexP].let { if (it) return false }

            var matched = indexS < s.length && (s[indexS] == p[indexP] || p[indexP] == '.')

            matched = if (indexP != p.length - 1 && p[indexP + 1] == '*'){
                match(indexS, indexP + 2) || (matched && match(indexS + 1, indexP))
            } else if (matched){
                match(indexS + 1, indexP + 1)
            } else
                false

            if (!matched) m[indexS][indexP] = true

            return matched
        }
        return match(0, 0)
    }
}