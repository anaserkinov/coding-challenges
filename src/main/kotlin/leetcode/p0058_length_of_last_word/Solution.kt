package leetcode.p0058_length_of_last_word

class Solution {
    fun lengthOfLastWord(s: String): Int {
        if (s.length == 1) return 1
        var result = 0
        var index = s.length - 1
        while (index >= 0){
            if (s[index--] == ' ') {
                if (result != 0) return result
            } else
                result ++
        }
        return result
    }
}