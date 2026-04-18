package leetcode.p0125_valid_palindrome

class Solution {

    fun isAlphanumeric(charCode: Int) =
        if (charCode in 48..57 || charCode in 97..122)
            charCode
        else if (charCode in 65..90)
            charCode + 32
        else
            -1


    fun isPalindrome(s: String): Boolean {
        if (s.length == 1) return true

        var left = 0
        var right = s.length - 1

        while (left < right){
            val leftCh = isAlphanumeric(s[left].code)
            if (leftCh == -1){
                left ++
                continue
            }
            val rightCh = isAlphanumeric(s[right].code)
            if (rightCh == -1){
                right --
                continue
            }
            if (leftCh != rightCh)
                return false
            left ++
            right --
        }

        return true
    }
}