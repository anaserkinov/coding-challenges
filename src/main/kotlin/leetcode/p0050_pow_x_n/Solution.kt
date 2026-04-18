package leetcode.p0050_pow_x_n

import kotlin.math.abs

class Solution {
    fun myPow(x: Double, n: Int): Double {
        var result = 1.0
        var pow = abs(n.toLong())
        var x = x
        while (pow != 0L){
            if (pow % 2 != 0L) result *= x
            x *= x
            pow = pow shr 1
        }

        return if (n >= 0) result else 1 / result
    }
}