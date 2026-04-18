package leetcode.p0198_house_robber

import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var pre1 = 0
        var pre2 = 0
        repeat(nums.size){
            val temp = pre1
            pre1 = max(pre2 + nums[it], pre1)
            pre2 = temp
        }
        return pre1
    }
}