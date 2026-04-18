package leetcode.p0704_binary_search

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size == 1) return if (nums.first() == target) 0 else -1
        var left = 0
        var right = nums.size - 1
        while (left <= right){
            val m = left + ((right - left) shr 1)
            when {
                nums[m] > target -> right = m - 1
                nums[m] < target -> left = m + 1
                else -> return m
            }
        }
        return -1
    }
}