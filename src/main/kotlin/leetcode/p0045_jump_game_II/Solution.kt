package leetcode.p0045_jump_game_II

class Solution {
    fun jump(nums: IntArray): Int {
        var result = 0
        var left = 0
        var right = 0
        while (left < nums.size - 1 && right < nums.size - 1){
            var maxI = left
            for (i in left..right){
                if (i + nums[i] > maxI + nums[maxI]) maxI = i
            }
            left = right + 1
            right = maxI + nums[maxI]
            result ++
        }
        return result
    }
}