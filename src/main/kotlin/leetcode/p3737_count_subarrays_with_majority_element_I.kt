package leetcode.p3737_count_subarrays_with_majority_element_I

class Solution {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
        var result = 0
        for (left in 0 until nums.size){
            var count = 0
            for (right in left until nums.size){
                if (nums[right] == target) count ++
                if (count > (right - left + 1)/2) result ++
            }
        }
        return result
    }
}