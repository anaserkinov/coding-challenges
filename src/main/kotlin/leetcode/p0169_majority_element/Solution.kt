package leetcode.p0169_majority_element

class Solution {
    fun majorityElement(nums: IntArray): Int {
        var vote = 0
        var candidate = 0
        for (num in nums){
            if (vote == 0) candidate = num
            if (candidate == num) vote ++ else vote --
        }
        return candidate
    }
}