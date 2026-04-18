package leetcode.p0055_jump_game

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var goal = nums.size - 1
        for (i in nums.size - 2 downTo  0){
            if (nums[i] >= goal - i) goal = i
        }
        return goal == 0
    }
}