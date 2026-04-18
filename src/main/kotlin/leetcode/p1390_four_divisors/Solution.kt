package leetcode.p1390_four_divisors

import kotlin.math.sqrt

class Solution {
    fun sumFourDivisors(nums: IntArray): Int {
        var sum = 0
        fun isPrime(x: Int): Boolean {
            if (x == 2) return true
            if (x < 2 || x % 2 == 0) return false
            var i = 3L
            while (i * i <= x) {
                if (x % i == 0L) return false
                i += 2
            }
            return true
        }

        for (num in nums) {
            val limit = sqrt(num.toDouble()).toInt()
            for (i in 2.. limit) {
                if (num % i == 0) {
                    val quotient = num / i
                    if (i == quotient || !isPrime(i)) break
                    val sqrt = sqrt(quotient.toDouble())

                    if (i.toDouble()== sqrt || isPrime(quotient)) {
                        sum += 1 + i + num / i + num
                    }
                    break
                }
            }
        }
        return sum
    }
}

fun main() {
    Solution()
        .sumFourDivisors(intArrayOf(6,10,14,15,21,22,26,33,35,38,39,46,51,55,57,58,62,65,69,74))
}