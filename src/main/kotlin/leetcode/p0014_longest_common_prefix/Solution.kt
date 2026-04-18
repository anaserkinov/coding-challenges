package leetcode.p0014_longest_common_prefix

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val chars = strs[0]
        var index = chars.length
        for (i in 1 until strs.size){
            val str = strs[i]
            var j = 0
            while (j < str.length){
                if (index == 0) return ""
                if (str[j] != chars[j]) break
                j++
                if (j == index) break
            }
            index = j
        }
        return chars.substring(0, index)
    }
}