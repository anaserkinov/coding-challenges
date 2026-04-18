package leetcode.p0053_maximum_subarray

import kotlin.math.max

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var maxEnding = 0
        nums.forEach {
            if (maxEnding < 0) maxEnding = 0
            maxEnding += it
            result = max(result, maxEnding)
        }
        return result
    }
}