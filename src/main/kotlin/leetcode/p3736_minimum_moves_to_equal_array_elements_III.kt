package leetcode.p3736_minimum_moves_to_equal_array_elements_III

class Solution {
    fun minMoves(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var result = 0
        var max = nums[0]
        for (i in 1 until nums.size){
            if (nums[i] > max) {
                result += i * (nums[i] - max)
                max = nums[i]
            } else result += max - nums[i]
        }
        return result
    }
}