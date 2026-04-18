package leetcode.p1437_check_if_all_1s_are_at_least_length_k_places_away

class Solution {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var lastPosition = -1
        for (i in nums.indices){
            if (nums[i] == 1) {
                if (lastPosition != -1 && i - lastPosition - 1 < k) return false
                lastPosition = i
            }
        }
        return true
    }
}