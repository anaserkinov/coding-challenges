package leetcode.p0128_longest_consecutive_sequence

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) return s.length

        val set = HashSet<Char>()

        var l = 0
        set.add(s[l])

        var result = 1
        (1 until s.length).forEach {  r ->
            val c = s[r]
            if (set.contains(c)){
                set.remove(s[l++])
                while (set.contains(s[l])){
                    set.remove(s[l++])
                }
            } else {
                set.add(c)
                result = max(result, set.size)
            }
        }

        return result
    }
}