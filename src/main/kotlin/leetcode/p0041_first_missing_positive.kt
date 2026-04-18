package leetcode.p0041_first_missing_positive

import kotlin.math.abs

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        for (i in 0 until nums.size)
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = n + 1

        for (i in 0 until nums.size){
            var num = abs(nums[i])
            if (num > n) continue
            num --
            if (nums[num] > 0)
                nums[num] = -nums[num]
        }

        for (i in 0 until nums.size){
            if (nums[i] >= 0) return i + 1
        }

        return n + 1
    }
}