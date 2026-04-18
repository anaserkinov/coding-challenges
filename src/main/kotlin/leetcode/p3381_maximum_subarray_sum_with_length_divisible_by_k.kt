package leetcode.p3381_maximum_subarray_sum_with_length_divisible_by_k

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val pSum = LongArray(nums.size + 1)
        for (i in 0 until nums.size)
            pSum[i + 1] = pSum[i] + nums[i]

        var result = Long.MIN_VALUE
        for (i in 0 until min(k, nums.size - k + 1)){
            var maxEnding = pSum[i + k] - pSum[i]
            for (j in i + 2 * k until pSum.size step k){
                val sum = pSum[j] - pSum[j - k]
                result = max(result, maxEnding)
                maxEnding = max(maxEnding + sum, sum)
            }
            result = max(result, maxEnding)
        }
        return result
    }
}