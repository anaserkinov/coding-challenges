package leetcode.p0076_minimum_window_substring

class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) return ""
        if (t.length == 1) { return if (s.contains(t.first())) t else "" }

        val frequency = IntArray(58)
        t.forEach { frequency[it.code - 65]++ }

        var resultL = 0
        var resultR = Int.MAX_VALUE

        var l = 0
        var r = 0
        var m = t.length

        while (r <= s.length){
            if (m == 0){
                if (r - l < resultR - resultL){
                    resultL = l
                    resultR = r
                }

                val lCode = s[l].code - 65
                frequency[lCode] ++
                if (frequency[lCode] > 0) m ++
                l ++
            } else {
                if (r < s.length){
                    val rCode = s[r].code - 65
                    if (frequency[rCode] > 0) m --
                    frequency[rCode] --
                }
                r ++
            }
        }

        return if (resultR == Int.MAX_VALUE) "" else s.substring(resultL, resultR)
    }
}