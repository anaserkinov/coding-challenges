package leetcode.p0027_remove_element

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        for (j in nums.indices) {
            if (nums[j] != `val`)
                nums[i++] = nums[j]
        }
        return i
    }
}