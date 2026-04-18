package leetcode.p0153_find_minimum_in_rotated_sorted_array

import kotlin.math.min

class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()
        var left = 0
        var right = nums.size - 1
        var res = Int.MAX_VALUE
        while (left <= right){
            val mid = (left + right) shr 1
            if (nums[mid] > nums[right])
                left = mid + 1
            else
                right = mid - 1
            res = min(res, nums[mid])
        }
        return res
    }
}

fun main() {
    println(
        Solution()
            .findMin(intArrayOf(3,4,5,1,2))
    )
    println(
        Solution()
            .findMin(intArrayOf(4,5,6,7,0,1,2))
    )
}