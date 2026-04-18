package leetcode.p3234_count_the_number_of_substrings_with_dominant_ones

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun numberOfSubstrings(s: String): Int {
        val n = s.length
        var result = 0
        var z = 0
        while((z * z) <= (n - z)) {
            var zero = 0
            var one = 0
            var left = 0
            var prefix = 0
            for (right in 0 until n) {
                val curr = s[right]
                if (curr == '0') zero += 1
                else one += 1
                while(left < right && zero > z) {
                    val prev = s[left++]
                    if (prev == '0') zero -= 1
                     else one -= 1
                }
                if (zero == z && one > 0 && zero * zero <= one) {
                    val m = max(prefix, left)
                    prefix = m
                    for (i in m until right) {
                        if (s[i] == '0') break
                        prefix += 1
                    }
                    result += 1 + min(prefix - left, one - z * z)
                }
            }
            z += 1
        }
        return result
    }
}