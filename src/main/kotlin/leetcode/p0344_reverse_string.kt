package leetcode.p0344_reverse_string

class Solution {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size - 1
        while (left < right){
            s[right] = s[left].also {
                s[left] = s[right]
            }
            left ++
            right --
        }
    }
}