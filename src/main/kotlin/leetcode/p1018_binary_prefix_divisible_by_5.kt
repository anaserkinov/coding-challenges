package leetcode.p1018_binary_prefix_divisible_by_5

class Solution {
    fun prefixesDivBy5(nums: IntArray): BooleanArray {
        val result = BooleanArray(nums.size)
        var number = 0
        for (i in 0 until nums.size){
            number = number shl 1
            number = number or nums[i]
            if (number % 5 == 0) result[i] = true
            number %= 5
        }
        return result
    }
}