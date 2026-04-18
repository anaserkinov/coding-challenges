package leetcode.p0028_find_the_index_of_the_first_occurrence_in_a_string

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.length > haystack.length) return -1
        var check = 0
        var index = 0
        while (index <= haystack.length){
            val c = haystack[index]
            if (c == needle[check++]){
                if (check == needle.length) return index - check + 1
            } else {
                index = index - check + 1
                check = 0
            }
            index ++
        }
        return -1
    }
}