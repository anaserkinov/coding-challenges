package leetcode.p1590_make_sum_divisible_by_p

import kotlin.math.min

class Solution {
    fun minSubarray(nums: IntArray, p: Int): Int {
        var sum = 0L
        for (num in nums) sum += num
        val k = (sum%p).toInt()
        if (k == 0) return 0
        var remainder = 0
        var result = nums.size
        val map = HashMap<Int, Int>()
        map[0] = -1

        for (i in 0 until nums.size){
            remainder = (remainder + nums[i]) % p
            val complement = (remainder - k + p) % p
            map[complement]?.let { result = min(result, i - it) }
            map[remainder] = i
        }
        return if (result == nums.size) -1 else result
    }
}