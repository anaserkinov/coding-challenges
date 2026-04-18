package leetcode.p0070_climbing_stairs

class Solution {
    fun climbStairs(n: Int): Int {
        var current = 1
        var pre = 1

        repeat(n - 1){
            val temp = current
            current += pre
            pre = temp
        }

        return current
    }
}