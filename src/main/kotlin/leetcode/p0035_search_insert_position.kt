package leetcode.p0035_search_insert_position

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right){
            val m = (left + right) shr 1
            when{
                nums[m] < target -> left = m + 1
                nums[m] > target -> right = m - 1
                else -> return m
            }
        }
        return ((left + right) shr 1) + 1
    }
}