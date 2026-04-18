package leetcode.p0029_divide_two_integers

import kotlin.math.abs

class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        if (divisor == 1) return dividend
        if (divisor == -1)
            return if (dividend == Int.MIN_VALUE) Int.MAX_VALUE else -dividend
        if (dividend == 0) return 0

        var result = 0L
        val isNegative = (dividend < 0) xor (divisor < 0)
        var carry = abs(dividend.toLong())
        val divisor = abs(divisor.toLong())
        while (carry >= divisor){
            var shift = 1
            var value = 0L
            while (value <= carry){
                value = divisor shl shift++
            }
            val v = divisor shl (shift - 2)
            carry -= v
            result += 1L shl (shift - 2)
        }
        if (isNegative) result = -result
        return when {
            result > Int.MAX_VALUE -> Int.MAX_VALUE
            result < Int.MIN_VALUE -> Int.MIN_VALUE
            else -> result.toInt()
        }
    }
}