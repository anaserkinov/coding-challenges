package leetcode.p0961_n_repeated_element_in_size_2n_array


class Solution {
    fun repeatedNTimes(nums: IntArray): Int {
        for (i in 0 until nums.size - 2){
            if (nums[i] == nums[i + 2] || nums[i + 1] == nums[i + 2])
                return nums[i + 2]
        }
        if (nums[0] == nums[3] || nums[0] == nums[1]) return nums[0]
        return -1
    }
}