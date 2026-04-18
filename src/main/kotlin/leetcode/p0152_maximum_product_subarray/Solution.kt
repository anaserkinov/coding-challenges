package leetcode.p0152_maximum_product_subarray

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxProduct(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var max = 1
        var min = 1
        var result = nums[0]
        for (num in nums){
            val temp = max * num
            max = max(temp, max(num * min, num))
            min = min(temp, min(num * min, num))
            result = max(result, max)
        }
        return result
    }
}