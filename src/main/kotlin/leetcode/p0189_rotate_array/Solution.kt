package leetcode.p0189_rotate_array

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val temp = IntArray(nums.size) { nums[it] }
        for (i in nums.indices) {
            temp[(i + k)%nums.size] = nums[i]
        }
        temp.copyInto(nums)
    }
}