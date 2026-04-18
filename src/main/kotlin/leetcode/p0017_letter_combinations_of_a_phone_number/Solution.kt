package leetcode.p0017_letter_combinations_of_a_phone_number

class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val res = ArrayList<String>(3 * digits.length)
        val digitToChar = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

        val sb = CharArray(digits.length)
        fun backtrack(i: Int) {
            if (i == digits.length) {
                res.add(String(sb))
                return
            }
            for (c in digitToChar[digits[i].code - 50]) {
                sb[i] = c
                backtrack(i + 1)
            }
        }

        backtrack(0)
        return res
    }
}