package leetcode.p0680_valid_palindrome_II

class Solution {
    fun validPalindrome(s: String): Boolean {
        fun isPalindrome(l: Int, r: Int): Boolean{
            var left = l
            var right = r
            while (left < right){
                if (s[left] != s[right]){
                    if (l != 0 || r != s.length - 1) return false
                    return isPalindrome(left + 1, right) ||
                            isPalindrome(left, right - 1)
                }
                left ++
                right --
            }
            return true
        }
        return isPalindrome(0, s.length - 1)
    }
}