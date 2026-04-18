package leetcode.p1925_count_square_sum_triples

import kotlin.math.abs
import kotlin.math.sqrt


class Solution {
    fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return abs(x)
    }
    fun countTriples(n: Int): Int {
        var count = 0
        val maxU = sqrt(n.toDouble()).toInt()
        for (u in 2..maxU){
            for (v in 1 until u) {
                if (((u - v) and 1) == 0) continue
                if (gcd(u, v) != 1) continue
                val c0 = u * u + v * v
                if (c0 > n) continue
                count += (n/c0) * 2
            }
        }
        return count
    }
}