package leetcode.p0424_longest_repeating_character_replacement

import kotlin.math.max

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        if (s.length <= 1) return s.length

        var result = 0
        val used = IntArray(26)

        var l = 0
        var r = 0
        var m = 0
        while (r < s.length){
            used[s[r].code - 65] ++
            m = max(m, used[s[r].code - 65])
            if (r - l + 1 - m > k){
                used[s[l].code - 65] --
                l ++
            }
            result = max(result, r - l + 1)
            r ++
        }

        return result
    }
}