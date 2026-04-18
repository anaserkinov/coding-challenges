package leetcode.p0875_koko_eating_bananas

import kotlin.math.ceil

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 0
        var right = piles.max()

        var res = right
        while (left <= right){
            val m = (left + right) shr 1
            val faster = let {
                var totalTime = 0.0
                piles.forEach {
                    totalTime += ceil(it.toDouble()/m)
                    if (totalTime > h) return@let false
                }
                totalTime <= h
            }
            if (faster){
                right = m - 1
                res = m
            } else {
                left = m + 1
            }
        }

        return res
    }
}

fun main() {
    println(
        Solution()
            .minEatingSpeed(
                intArrayOf(3,6,7,11),
                8
            )
    )
}