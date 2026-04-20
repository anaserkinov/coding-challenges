package leetcode.p0209_minimum_size_subarray_sum

import kotlin.math.min

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var sum = 0
        var result = Int.MAX_VALUE

        for (right in nums.indices) {
            sum += nums[right]
            while (sum >= target){
                result = min(result, right - left + 1)
                if (result == 1) return result
                sum -= nums[left ++]
            }
        }
        return if (result == Int.MAX_VALUE) 0 else result
    }
}