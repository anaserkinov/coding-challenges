package leetcode.p0198_house_robber_II

import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(
            maxOf(nums, 1, nums.size),
            maxOf(nums, 0, nums.size - 1)
        )
    }

    private fun maxOf(nums: IntArray, start: Int, end: Int): Int {
        var rob1 = 0
        var rob2 = 0

        for (i in start until end){
            val newRob = max(rob1 + nums[i], rob2)
            rob1 = rob2
            rob2 = newRob
        }
        return rob2
    }
}