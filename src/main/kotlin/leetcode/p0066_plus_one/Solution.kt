package leetcode.p0066_plus_one

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var index = digits.size - 1
        while (index >= 0) {
            val digit = digits[index] + 1
            digits[index--] = digit % 10
            if (digit < 10) return digits
        }
        val result = IntArray(digits.size + 1)
        result[0] = 1
        return result
    }
}