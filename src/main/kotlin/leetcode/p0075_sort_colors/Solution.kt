package leetcode.p0075_sort_colors

class Solution {
    fun sortColors(nums: IntArray): Unit {
        var left = 0
        var right = nums.size - 1
        var i = 0
        while (i <= right){
            if (nums[i] == 0) {
                nums[left] = nums[i].also { nums[i] = nums[left++] }
            } else if (nums[i] == 2)
                nums[right] = nums[i].also { nums[i--] = nums[right--] }
            i ++
        }
    }
}