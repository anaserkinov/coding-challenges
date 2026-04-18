package leetcode.p0242_valid_anagram

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        if (s.length == 1 && s.first() == t.first()) return true

        val sArray = IntArray(26)
        val tArray = IntArray(26)

        s.forEach { sArray[it.code - 97]++ }
        t.forEach { tArray[it.code - 97]++ }

        repeat(26){
            if (sArray[it] != tArray[it])
                return false
        }
        return true
    }
}