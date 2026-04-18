package leetcode.p0005_longest_palindromic_substring


class Solution {
    fun longestPalindrome(s: String): String {
        if (s.length == 1) return s
        val size = s.length
        var start = 0
        var length = 1
        val isPalindrome = BooleanArray(size * size)
        repeat(size){
            isPalindrome[it * size + it] = true
        }
        for (mLength in 2..size){
            for (mStart in 0 .. size - mLength){
                val end = mStart + mLength - 1
                if (s[mStart] == s[end] && (end - mStart == 1 || isPalindrome[(mStart + 1) * size + end - 1])){
                    isPalindrome[mStart * size + end] = true
                    if (mLength > length){
                        start = mStart
                        length = mLength
                    }
                }
            }
        }
        return s.substring(start, start + length)
    }
}